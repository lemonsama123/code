package com.lemon.mybatis.mapper;

import com.lemon.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname EmpMapper
 * @Description TODO
 * @Date 2022/7/3 16:25
 * @Created yj
 */
public interface EmpMapper {

    List<Emp> getAllEmp();

    Emp getEmpAndDept(@Param("eid") Integer eid);

    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);


}
