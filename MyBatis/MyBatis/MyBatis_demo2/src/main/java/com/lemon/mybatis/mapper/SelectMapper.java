package com.lemon.mybatis.mapper;

import com.lemon.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname SelectMapper
 * @Description TODO
 * @Date 2022/7/3 14:32
 * @Created yj
 */
public interface SelectMapper {

    public List<User> getUserById(@Param("id") Integer id);

    List<User> getAllUser();
}
