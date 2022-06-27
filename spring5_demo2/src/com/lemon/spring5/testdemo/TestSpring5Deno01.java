package com.lemon.spring5.testdemo;

import com.lemon.spring5.bean.Orders;
import com.lemon.spring5.collectiontype.Book;
import com.lemon.spring5.collectiontype.Course;
import com.lemon.spring5.collectiontype.Stu;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring5Deno01 {

    @Test
    public void testCollection1() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");
        Stu stu = context.getBean("stu", Stu.class);
        stu.test();
    }

    @Test
    public void testCollection2() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean2.xml");
        Book book1 = context.getBean("book", Book.class);
        Book book2 = context.getBean("book", Book.class);
        System.out.println(book1);
        System.out.println(book2);
    }

    @Test
    public void test3() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("bean4.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println("4. 获取bean对象");
        System.out.println(orders);
        context.close();
    }
}
