package com.lemon.spring5.service;

import com.lemon.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserService {

//    @Autowired
//    @Qualifier(value = "userDaoImpl1")
//    private UserDao userDao;

    @Value(value = "abc")
    private String name;

//    private UserDao userDao;

    public void add() {
        System.out.println("service add......" + name);
//        userDao.add();
    }
}
