package com.fabyosk.fsknotes.persistence.dao.jpa;


import com.fabyosk.fsknotes.model.Note;
import com.fabyosk.fsknotes.persistence.dao.NotesDao;
import org.springframework.stereotype.Repository;

@Repository
public class JpaNotesDao extends GenericJpaDao<Note> implements NotesDao {

    /**
     * @see GenericJpaDao#GenericJpaDao(Class)
     */
    public JpaNotesDao() {
        super(Note.class);
    }
}
