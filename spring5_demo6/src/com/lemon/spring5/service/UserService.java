package com.lemon.spring5.service;

import com.lemon.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserService {

    @Autowired
    private UserDao userDao;


    public void accountMoney() {
            userDao.reduceMoney();
//            int i =  10 / 0;
            userDao.addMoney();
    }
}
