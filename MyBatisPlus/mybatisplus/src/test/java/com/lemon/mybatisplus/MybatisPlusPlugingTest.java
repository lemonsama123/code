package com.lemon.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lemon.mybatisplus.mapper.ProductMapper;
import com.lemon.mybatisplus.mapper.UserMapper;
import com.lemon.mybatisplus.pojo.Product;
import com.lemon.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Classname MybatisPlusPlugingTest
 * @Description TODO
 * @Date 2022/7/7 16:36
 * @Created yj
 */
@SpringBootTest
public class MybatisPlusPlugingTest {

    @Autowired
    UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void testPage() {
        Page<User> page = new Page<>(1, 3);
        userMapper.selectPage(page, null);
        System.out.println(page.getRecords());
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getPages());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }

    @Test
    public void testProduct01() {
        Product productLi = productMapper.selectById(1);
        System.out.println("小李查询的商品价格：" + productLi.getPrice());

        Product productWang = productMapper.selectById(1);
        System.out.println("小王查询的商品价格：" + productWang.getPrice());

        productLi.setPrice(productLi.getPrice() + 50);
        productMapper.updateById(productLi);

        productWang.setPrice(productWang.getPrice() - 30);
        int res = productMapper.updateById(productWang);

        if (res == 0) {
            productWang = productMapper.selectById(1);
            productWang.setPrice(productWang.getPrice() - 30);
            productMapper.updateById(productWang);
        }

        Product productLaoban = productMapper.selectById(1);
        System.out.println("老板查询的商品价格：" + productLaoban.getPrice());
    }
}
