package com.fabyosk.fsknotes.services.user;

import com.fabyosk.fsknotes.model.Note;
import com.fabyosk.fsknotes.model.User;

import java.util.List;

public class UserServices implements UserServiceInteface {
    private User currentUser;

    @Override
    public void add(Note note) {
        currentUser.addNote(note);
    }

    @Override
    public void delete() {

    }

    @Override
    public List list() {
        return null;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
