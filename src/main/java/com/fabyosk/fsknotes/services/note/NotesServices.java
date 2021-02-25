package com.fabyosk.fsknotes.services.note;

import com.fabyosk.fsknotes.database.ConnectionManager;
import com.fabyosk.fsknotes.model.Note;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class NotesServices {
    private Connection dbConnection;

    public void add(Note note, int userId) {
        ConnectionManager connectionManager = new ConnectionManager();
        dbConnection = connectionManager.getConnection();

        Statement statement = null;
        try {
            statement = dbConnection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String query = "insert into notes(content, user_id) \n" +
                "values ('" + note.getContent() + "'," + userId + ")";

        try {
            int resultSet = statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Note> getNotesById(int userId) {
        List<Note> noteList = new LinkedList<>();
        ConnectionManager connectionManager = new ConnectionManager();
        dbConnection = connectionManager.getConnection();

        Statement statement = null;
        try {
            statement = dbConnection.createStatement();


            String query = "SELECT DISTINCT n.content\n" +
                    "FROM users as u, notes as n\n" +
                    "WHERE " + userId + " = n.user_id;";

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String content = resultSet.getString("content");
                noteList.add(new Note(content));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return noteList;
    }

}
