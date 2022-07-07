package com.lemon.mybatisplus;

import com.lemon.mybatisplus.enums.SexEnum;
import com.lemon.mybatisplus.mapper.UserMapper;
import com.lemon.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Classname MyBatisPlusEnumTest
 * @Description TODO
 * @Date 2022/7/7 18:53
 * @Created yj
 */
@SpringBootTest
public class MyBatisPlusEnumTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test() {
        User user = new User();
        user.setName("admin");
        user.setAge(33);
        user.setSex(SexEnum.MALE);
        userMapper.insert(user);
    }
}
