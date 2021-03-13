package com.fabyosk.fsknotes.services.note;

import com.fabyosk.fsknotes.model.Note;

import java.util.List;

public interface NoteServiceInterface {

    /**
     * Adds a new note
     *
     * @param note the new note to add
     */
    void add(Note note);
    Note getById(int id);
    /**
     * Finds a user by name
     *
     * @param username the user name used to lookup a user
     * @return a new User if found, null otherwise
     */

    /**
     * Finds notes users
     *
     * @return list of notes if found, null otherwise
     */
    List<Note> list();

    /**
     * Count the number of existing notes
     *
     * @return the number of notes
     */
    int count();
}
