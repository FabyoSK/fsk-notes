package com.fabyosk.fsknotes.services.note;

import com.fabyosk.fsknotes.model.Note;
import com.fabyosk.fsknotes.persistence.dao.NotesDao;

import java.util.List;

public class NoteService implements NoteServiceInterface{
    private NotesDao notesDao;
    @Override
    public void add(Note note) {

    }

    @Override
    public List<Note> list() {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    public void setNotesDao(NotesDao notesDao) {
        this.notesDao = notesDao;
    }

    public void setNoteDao(NotesDao noteDao) {
        this.notesDao =noteDao;
    }
}
