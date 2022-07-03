package com.lemon.mybatis.mapper;

import com.lemon.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @Classname DeptMapper
 * @Description TODO
 * @Date 2022/7/3 16:26
 * @Created yj
 */
public interface DeptMapper {

    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);

    Dept getDeptAndEmp(@Param("did") Integer did);

    Dept getDeptAndEmpByStepOne(@Param("did") Integer did);
}
