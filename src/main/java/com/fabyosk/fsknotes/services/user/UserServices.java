package com.fabyosk.fsknotes.services.user;

import com.fabyosk.fsknotes.model.User;
import com.fabyosk.fsknotes.persistence.dao.UserDao;

import java.util.List;

public class UserServices implements UserServiceInteface {
    private UserDao userDao;

    @Override
    public List<User> list() {
        return userDao.findAll();
    }

    @Override
    public void add(User user) {
        userDao.saveOrUpdate(user);
    }

    @Override
    public User findByName(String username) {
        return null;
    }


    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public int count() {
        return 0;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
