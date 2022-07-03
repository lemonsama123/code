package com.lemon.mybatis.mapper;

import com.lemon.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname DynamicSQL
 * @Description TODO
 * @Date 2022/7/3 19:55
 * @Created yj
 */
public interface DynamicSQLMapper {

    List<Emp> getEmpByCondition(Emp emp);

    List<Emp> getEmpByChoose(Emp emp);

    int deleteByArray(@Param("eids") Integer[] eids);

    int insertMoreByList(@Param("emps")List<Emp> emps);
}
