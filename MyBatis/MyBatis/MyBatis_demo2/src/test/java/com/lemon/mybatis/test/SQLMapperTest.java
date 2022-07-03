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
    public void testGetUserByLike() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> a = mapper.getUserByLike("a");
        System.out.println(a);
    }
}
