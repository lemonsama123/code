package com.lemon.spring5.testdemo;

import com.lemon.spring5.collectiontype.Book;
import com.lemon.spring5.collectiontype.Course;
import com.lemon.spring5.collectiontype.Stu;
import com.lemon.spring5.factotrybean.MyBean;
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
        Book book = context.getBean("book", Book.class);
        book.test();
    }

    @Test
    public void test3() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean3.xml");
        Course course = context.getBean("myBean", Course.class);
        System.out.println(course);
    }
}
