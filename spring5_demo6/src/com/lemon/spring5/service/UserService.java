package com.lemon.spring5.service;

import com.lemon.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public void accountMoney() {
        try {
            userDao.reduceMoney();
            int i = 10 / 0;
            userDao.addMoney();
        }  catch (Exception e) {

        } finally {

        }
    }
}
