package com.lemon.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lemon.mybatisplus.mapper.UserMapper;
import com.lemon.mybatisplus.pojo.User;
import com.lemon.mybatisplus.service.UserService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2022/7/7 12:36
 * @Created yj
 */
@Service
public class UserServiceImpl
        extends ServiceImpl<UserMapper, User>
        implements UserService {
}
