package com.lemon.mybatis.test;

import com.lemon.mybatis.mapper.ParameterMapper;
import com.lemon.mybatis.pojo.User;
import com.lemon.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Classname ParameterMapperTest
 * @Description TODO
 * @Date 2022/7/3 12:35
 * @Created yj
 */
public class ParameterMapperTest {

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(user -> System.out.println(user));
    }

    @Test
    public void testJDBC() throws ClassNotFoundException {
        Class.forName("");
    }
}
