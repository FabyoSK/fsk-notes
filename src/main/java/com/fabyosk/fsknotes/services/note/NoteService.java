package com.fabyosk.fsknotes.services.note;

import com.fabyosk.fsknotes.model.Note;
import com.fabyosk.fsknotes.persistence.dao.NotesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService implements NoteServiceInterface {
    private NotesDao notesDao;

    @Override
    public void add(Note note) {
        notesDao.saveOrUpdate(note);
    }

    @Override
    public List<Note> list() {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public Note getById(int id) {
       return notesDao.findById(id);
    }

    @Autowired
    public void setNoteDao(NotesDao noteDao) {
        this.notesDao = noteDao;
    }
}
