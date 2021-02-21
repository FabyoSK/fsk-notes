package com.fabyosk.fsknotes.boot;

import com.fabyosk.fsknotes.model.Note;
import com.fabyosk.fsknotes.model.User;
import com.fabyosk.fsknotes.repositories.NoteRepository;
import com.fabyosk.fsknotes.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
    private final UserRepository userRepository;
    private final NoteRepository noteRepository;

    public Bootstrap(UserRepository userRepository, NoteRepository noteRepository) {
        this.userRepository = userRepository;
        this.noteRepository = noteRepository;
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

        noteRepository.save(n1);
        noteRepository.save(n2);
        noteRepository.save(n3);
        noteRepository.save(n4);

        userRepository.save(user1);

        System.out.println("num "+ noteRepository.count());
    }
}
