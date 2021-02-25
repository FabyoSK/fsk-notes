package com.fabyosk.fsknotes.services.user;

import com.fabyosk.fsknotes.database.ConnectionManager;
import com.fabyosk.fsknotes.model.Note;
import com.fabyosk.fsknotes.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserServices implements UserServiceInteface {
    private User currentUser;
    private Connection dbConnection;

    @Override
    public void add(Note note) {
        currentUser.addNote(note);
    }

    @Override
    public void delete() {

    }

    @Override
    public List list() {
        return null;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void addUser(User user) {
        ConnectionManager connectionManager = new ConnectionManager();
        dbConnection = connectionManager.getConnection();

        Statement statement = null;
        try {
            statement = dbConnection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String query = "insert into users(user_name) values ('" + user.getName() + "')";

        try {
            int resultSet = statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public User findByName(String username) {
        ConnectionManager connectionManager = new ConnectionManager();
        dbConnection = connectionManager.getConnection();

        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = dbConnection.createStatement();
            String query = "SELECT * FROM users \n" +
                    "WHERE user_name ='" + username + "'";

            resultSet = statement.executeQuery(query);


            if (resultSet.next()) {
                String usernameValue;
                usernameValue = resultSet.getString("user_name");

                connectionManager.close();
                return new User(username);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public User findById(int userId) {
        ConnectionManager connectionManager = new ConnectionManager();
        dbConnection = connectionManager.getConnection();

        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = dbConnection.createStatement();

            String query = "SELECT * FROM users \n" +
                    "WHERE user_id= '" + userId + "'";

            resultSet = statement.executeQuery(query);


            if (resultSet.next()) {
                User newUser = new User(resultSet.getString("user_name"));
                connectionManager.close();

                return newUser;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        connectionManager.close();
        return null;
    }
}
