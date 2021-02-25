package com.fabyosk.fsknotes;

import com.fabyosk.fsknotes.model.Note;
import com.fabyosk.fsknotes.model.User;
import com.fabyosk.fsknotes.services.note.NotesServices;
import com.fabyosk.fsknotes.services.user.UserServices;

import java.util.List;

public class AppTest {
    public static void main(String[] args) {
        System.out.println("hello world");


        UserServices userServices = new UserServices();

        User userFoundedByName = userServices.findByName("fsk");
        User userFoundedById = userServices.findById(2);

        System.out.println(userFoundedByName.getName() + "Founded by name");
        System.out.println(userFoundedById.getName() + "Founded by id");


        User newUser = new User("SKA");
        userServices.addUser(newUser);

        System.out.println(newUser.getName() + " added on db");

        NotesServices notesServices = new NotesServices();
        notesServices.add(new Note("Ser ou nao ser, eis a questao"), 2);

        List<Note> notes = notesServices.getNotesById(2);

        for (Note n : notes) {
            System.out.println(n.getContent());
        }
    }
}
