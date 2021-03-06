package com.fabyosk.fsknotes.services.user;

import com.fabyosk.fsknotes.model.User;

import java.util.List;

public interface UserServiceInteface {


    /**
     * Adds a new user
     *
     * @param user the new user to add
     */
    void add(User user);

    /**
     * Finds a user by name
     *
     * @param username the user name used to lookup a user
     * @return a new User if found, null otherwise
     */
    User findByName(String username);

    /**
     * Finds all users
     *
     * @return list of users if found, null otherwise
     */
    List<User> list();

    /**
     * Count the number of existing users
     *
     * @return the number of users
     */
    int count();

}
