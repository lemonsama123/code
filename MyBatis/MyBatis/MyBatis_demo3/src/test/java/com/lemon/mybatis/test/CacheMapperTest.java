package com.lemon.mybatis.test;

import com.lemon.mybatis.mapper.CacheMapper;
import com.lemon.mybatis.pojo.Emp;
import com.lemon.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname CacheMapperTest
 * @Description TODO
 * @Date 2022/7/3 22:00
 * @Created yj
 */
public class CacheMapperTest {

    @Test
    public void testOneCache() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp empById1 = mapper.getEmpById(1);
//        mapper.insertEmp(new Emp(null, "abc", 23, "男", "123@qq.com"));
        sqlSession.clearCache();
        Emp empById2 = mapper.getEmpById(1);
        System.out.println(empById1);
        System.out.println(empById2);
    }

    @Test
    public void testTwoCache() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
            CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
            System.out.println(mapper1.getEmpById(1));
            sqlSession1.close();
            CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            System.out.println(mapper2.getEmpById(1));
            sqlSession2.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}