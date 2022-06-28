package com.lemon.spring5.test;

import com.lemon.spring5.config.TxConfig;
import com.lemon.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class TestTX {

    @Test
    public void testAccount1() {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }

    @Test
    public void testAccount2() {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }

    @Test
    public void testAccount3() {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }

    @Test
    public void testAccount4() {
        GenericApplicationContext context = new GenericApplicationContext();
        context.refresh();
        context.registerBean("user1", User.class, () -> new User());
        User user = context.getBean("user1", User.class);
        System.out.println(user);
    }
}
