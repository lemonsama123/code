import com.lemon.mybatis.mapper.DynamicSQLMapper;
import com.lemon.mybatis.pojo.Emp;
import com.lemon.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname DynamicSQLMapperTest
 * @Description TODO
 * @Date 2022/7/3 20:09
 * @Created yj
 */
public class DynamicSQLMapperTest {

    @Test
    public void testInsertMoreByList() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null, "a1", 23, "男", "123@qq.com");
        Emp emp2 = new Emp(null, "a2", 23, "男", "123@qq.com");
        Emp emp3 = new Emp(null, "a3", 23, "男", "123@qq.com");
        List<Emp> list = Arrays.asList(emp1, emp2, emp3);
        int res = mapper.insertMoreByList(list);
        System.out.println(res);
    }

    @Test
    public void testGetEmpByCondition() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> empByCondition = mapper.getEmpByCondition(new Emp(null, "张三", null, "男", "123@qq.com"));
        System.out.println(empByCondition);
    }

    @Test
    public void testGetEmpByChoose() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> empByChoose = mapper.getEmpByChoose(new Emp(null, "张三", null, "男", "123@qq.com"));
        System.out.println(empByChoose);
    }

    @Test
    public void testDeleteMoreByArray() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int i = mapper.deleteByArray(new Integer[]{6, 7, 8});
        System.out.println(i);
    }
}
