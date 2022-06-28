package com.lemon.spring5.test;

import com.lemon.spring5.entity.Book;
import com.lemon.spring5.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestBook {

    @Test
    public void testJdbcTemplate() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setUserId("1");
        book.setUsername("javac");
        book.setUstatus("a");
//        bookService.addBook(book);
//        bookService.update(book);
//        bookService.delete("1");
//        System.out.println(bookService.findCount());
//        Book one = bookService.findOne("1");
//        System.out.println(one);
//        List<Book> all = bookService.findAll();
//        System.out.println(all);
//        List<Object[]> batchArgs = new ArrayList<>();
//        Object[] o1 = {"3", "java", "a"};
//        Object[] o2 = {"4", "c++", "b"};
//        Object[] o3 = {"5", "mysql", "c"};
//        batchArgs.add(o1);
//        batchArgs.add(o2);
//        batchArgs.add(o3);
//        bookService.batchAdd(batchArgs);

//        List<Object[]> batchArgs = new ArrayList<>();
//        Object[] o1 = {"java123", "a", "3"};
//        Object[] o2 = {"c++123", "b", "4"};
//        Object[] o3 = {"mysql123", "c", "5"};
//        batchArgs.add(o1);
//        batchArgs.add(o2);
//        batchArgs.add(o3);
//        bookService.batchUpdate(batchArgs);

        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"3"};
        Object[] o2 = {"4"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        bookService.batchDelete(batchArgs);
    }
}
