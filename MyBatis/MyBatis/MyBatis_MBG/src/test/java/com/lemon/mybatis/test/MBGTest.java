package com.lemon.mybatis.test;

import com.lemon.mybatis.mapper.EmpMapper;
import com.lemon.mybatis.pojo.Emp;
import com.lemon.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Classname MBGTest
 * @Description TODO
 * @Date 2022/7/3 23:15
 * @Created yj
 */
public class MBGTest {

    @Test
    public void testMBG() {
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

//            List<Emp> list = mapper.selectByExample(null);
//            list.forEach(emp -> System.out.println(emp));

//            EmpExample example = new EmpExample();
//            example.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThanOrEqualTo(20);
//            example.or().andDidIsNotNull();
//            List<Emp> list = mapper.selectByExample(example);
//            list.forEach(emp -> System.out.println(emp));

            mapper.updateByPrimaryKeySelective(new Emp(1, "admin", 22, null, "456@qq.com", 3));

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
