package com.fabyosk.fsknotes.services.user;

import com.fabyosk.fsknotes.model.User;
import com.fabyosk.fsknotes.persistence.dao.UserDao;
import com.fabyosk.fsknotes.utils.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        return userDao.findByName(username);
    }


    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public int count() {
        return 0;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
