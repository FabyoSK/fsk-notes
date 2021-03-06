package com.fabyosk.fsknotes.services.user;

import com.fabyosk.fsknotes.model.User;
import com.fabyosk.fsknotes.persistence.dao.UserDao;

import java.util.List;

public class UserServices {
    private UserDao userDao;

    public List<User> list() {
        return userDao.findAll();
    }


    public void add(User user) {
        userDao.saveOrUpdate(user);
    }

    public boolean authenticate(String username, String password) {
        return false;
    }


    public User findById(Integer id) {
        return userDao.findById(id);
    }


    public int count() {
        return 0;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
