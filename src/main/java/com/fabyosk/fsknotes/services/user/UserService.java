package com.fabyosk.fsknotes.services.user;

import com.fabyosk.fsknotes.model.User;

import java.util.List;

public class UserService implements UserServiceInteface {
    @Override
    public boolean authenticate(String username, String password) {
        return false;
    }

    @Override
    public void add(User user) {

    }

    @Override
    public User findByName(String username) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }
}
