package com.fabyosk.fsknotes;

import com.fabyosk.fsknotes.model.Note;
import com.fabyosk.fsknotes.model.User;
import com.fabyosk.fsknotes.repositories.NoteRepositorie;
import com.fabyosk.fsknotes.repositories.UserRepositorie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
    private final UserRepositorie userRepositorie;
    private final NoteRepositorie noteRepositorie;

    public Bootstrap(UserRepositorie userRepositorie, NoteRepositorie noteRepositorie) {
        this.userRepositorie = userRepositorie;
        this.noteRepositorie = noteRepositorie;
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("fsk");

        Note n1 = new Note("Ver One Piece");
        Note n2 = new Note("Ir ver minhas Lolis no porão, digo NOSSAS Lolis");
        Note n3 = new Note("AWESOME");
        Note n4 = new Note("KKKATXUPPINOXX");

        user1.addNote(n1);
        user1.addNote(n2);
        user1.addNote(n3);
        user1.addNote(n4);

        noteRepositorie.save(n1);
        noteRepositorie.save(n2);
        noteRepositorie.save(n3);
        noteRepositorie.save(n4);

        userRepositorie.save(user1);
    }
}
