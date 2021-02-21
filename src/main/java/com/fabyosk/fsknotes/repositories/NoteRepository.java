package com.fabyosk.fsknotes.repositories;

import com.fabyosk.fsknotes.model.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {
}
