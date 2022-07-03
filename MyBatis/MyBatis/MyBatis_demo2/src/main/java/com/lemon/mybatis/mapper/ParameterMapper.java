package com.lemon.mybatis.mapper;

import com.lemon.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Classname UserMapper
 * @Description TODO
 * @Date 2022/7/3 12:27
 * @Created yj
 */
public interface ParameterMapper {

    User checkLoginByParam(@Param("username") String username, @Param("password") String password);

    int insertUser(User user);

    User checkLoginByMap(Map<String, Object> map);

    User checkLogin(String username, String password);

    User getUserByUsername(String username);

    List<User> getAllUser();


}
