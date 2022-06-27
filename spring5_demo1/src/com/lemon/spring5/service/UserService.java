package com.lemon.spring5.service;

import com.lemon.spring5.dao.UserDao;

public class UserService {

    UserDao userDao;

    public void add() {
        System.out.println("service add......");
        userDao.update();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
