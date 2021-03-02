package com.fabyosk.fsknotes.boot;

import com.fabyosk.fsknotes.model.Note;
import com.fabyosk.fsknotes.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("fsk");

        Note n1 = new Note("Ver","One Piece");
        Note n2 = new Note("Ir ver minhas Lolis no porão"," digo NOSSAS Lolis");
        Note n3 = new Note("AWESOME","Mindblowing??");
        Note n4 = new Note("KKKATXUPPINOXX", "NOX");

        user1.addNote(n1);
        user1.addNote(n2);
        user1.addNote(n3);
        user1.addNote(n4);


    }
}
