package com.lemon.mybatis.test;

import com.lemon.mybatis.mapper.SQLMapper;
import com.lemon.mybatis.pojo.User;
import com.lemon.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Classname SQLMapperTest
 * @Description TODO
 * @Date 2022/7/3 15:34
 * @Created yj
 */
public class SQLMapperTest {

    @Test
    public void testDeleteMore() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        int i = mapper.deleteMore("4,6,7");
        System.out.println(i);
    }
    @Test
    public void testGetUserByLike() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> a = mapper.getUserByLike("a");
        System.out.println(a);
    }

    @Test
    public void testGetUserByTableName() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> list = mapper.getUserByTableName("t_user");
        System.out.println(list);
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        User user = new User(null, "张三", "123", 23, "男", "123@qq.com");
        System.out.println(user);
        mapper.insertUser(user);
        System.out.println(user);
    }
}
