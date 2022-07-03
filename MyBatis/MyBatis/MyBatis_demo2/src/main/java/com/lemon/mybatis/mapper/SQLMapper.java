package com.lemon.mybatis.mapper;

import com.lemon.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname SQLMapper
 * @Description TODO
 * @Date 2022/7/3 15:31
 * @Created yj
 */
public interface SQLMapper {

    List<User> getUserByLike(@Param("username") String username);

    int deleteMore(@Param("ids") String ids);

    List<User> getUserByTableName(@Param("tableName") String tableName);

    void insertUser(User user);
}
