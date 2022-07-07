package com.lemon.mybatisplus;

import com.lemon.mybatisplus.pojo.User;
import com.lemon.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname MyBatisPlusServiceTest
 * @Description TODO
 * @Date 2022/7/7 12:38
 * @Created yj
 */
@SpringBootTest
public class MyBatisPlusServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetCount() {
        long count = userService.count();
        System.out.println(count);
    }

    @Test
    public void testBatchInsert() {
        List<User> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setName("lemon" + i);
            user.setAge(20 + i);
            user.setEmail(String.format("lemon%d@qq.com", i));
            list.add(user);
        }
        boolean b = userService.saveBatch(list);
        System.out.println(b);
    }
}
