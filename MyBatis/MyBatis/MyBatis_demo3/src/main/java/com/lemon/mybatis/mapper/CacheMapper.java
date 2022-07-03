package com.lemon.mybatis.mapper;

import com.lemon.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @Classname CacheMapper
 * @Description TODO
 * @Date 2022/7/3 21:58
 * @Created yj
 */
public interface CacheMapper {

    Emp getEmpById(@Param("eid") Integer eid);

    void insertEmp(Emp emp);
}
