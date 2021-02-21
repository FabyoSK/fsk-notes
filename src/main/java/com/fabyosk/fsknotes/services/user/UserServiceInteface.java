package com.fabyosk.fsknotes.services.user;

import com.fabyosk.fsknotes.model.Note;

import java.util.List;

public interface UserServiceInteface {
    void add(Note note);

    void delete();

    List list();
}
