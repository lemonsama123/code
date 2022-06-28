package com.lemon.spring5.service;

import com.lemon.spring5.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemon.spring5.entity.Book;

import java.util.List;


@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public void addBook(Book book) {
        bookDao.add(book);
    }

    public void update(Book book) {
        bookDao.updateBook(book);
    }

    public void delete(String id) {
        bookDao.deleteBook(id);
    }

    public int findCount() {
        return bookDao.selectCount();
    }

    public Book findOne(String id) {
        return bookDao.findBookInfo(id);
    }

    public List<Book> findAll() {
        return bookDao.findAllBook();
    }

    public void batchAdd(List<Object[]> batchArgs) {
        bookDao.batchAddBook(batchArgs);
    }

    public void batchUpdate(List<Object[]> batchArgs) {
        bookDao.batchUpdateBook(batchArgs);
    }

    public void batchDelete(List<Object[]> batchArgs) {
        bookDao.batchDeleteBook(batchArgs);
    }
}
