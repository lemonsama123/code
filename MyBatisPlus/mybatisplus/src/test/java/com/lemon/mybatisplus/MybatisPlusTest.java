package com.lemon.mybatisplus;

import com.lemon.mybatisplus.mapper.UserMapper;
import com.lemon.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname MybatisPlusTest
 * @Description TODO
 * @Date 2022/7/7 11:40
 * @Created yj
 */
@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setEmail("zhangsan@lemon.com");
        int res = userMapper.insert(user);
        System.out.println(res);
        System.out.println(user.getId());
    }

    @Test
    public void testDeleteByID() {
        int res = userMapper.deleteById(1544893981924544514L);
        System.out.println(res);
    }

    @Test
    public void testDeleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 23);
        int res = userMapper.deleteByMap(map);
        System.out.println(res);
    }

    @Test
    public void testDeleteByBatchIds() {
        List<Long> list = Arrays.asList(1L, 2L, 3L);
        int res = userMapper.deleteBatchIds(list);
        System.out.println(res);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(4L);
        user.setName("李四");
        user.setEmail("lisi@lemon.com");
        int res = userMapper.updateById(user);
        System.out.println(res);
    }

    @Test
    public void testSelect() {
//        User user = userMapper.selectById(1L);
//        System.out.println(user);

//        List<Long> list = Arrays.asList(1L, 2L, 3L);
//        List<User> users = userMapper.selectBatchIds(list);
//        users.forEach(System.out::println);

//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "Jack");
//        map.put("age", 20);
//        List<User> users = userMapper.selectByMap(map);
//        users.forEach(System.out::println);

        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);

//        Map<String, Object> map = userMapper.selectMapById(4L);
//        System.out.println(map);
    }
}
