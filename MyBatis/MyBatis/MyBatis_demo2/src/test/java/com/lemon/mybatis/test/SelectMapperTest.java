package com.lemon.mybatis.test;

import com.lemon.mybatis.mapper.SelectMapper;
import com.lemon.mybatis.pojo.User;
import com.lemon.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Classname SelectMapperTest
 * @Description TODO
 * @Date 2022/7/3 14:34
 * @Created yj
 */
public class SelectMapperTest {
    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> list = mapper.getAllUser();
        System.out.println(list);
    }

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> list = mapper.getUserById(3);
        System.out.println(list);
    }
}
