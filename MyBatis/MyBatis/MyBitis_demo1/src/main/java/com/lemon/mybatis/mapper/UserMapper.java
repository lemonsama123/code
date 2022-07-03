package com.lemon.mybatis.mapper;

import com.lemon.mybatis.pojo.User;

import java.util.List;

/**
 * @Classname UserMapper
 * @Description TODO
 * @Date 2022/7/3 10:09
 * @Created yj
 */
public interface UserMapper {

    int insertUser();

    int updateUser();

    void deleteUser();

    User getUserById();

    List<User> getAllUser();
}
