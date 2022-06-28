package com.lemon.spring5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lemon.spring5.entity.Book;

import java.util.Arrays;
import java.util.List;


@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void add(Book book) {
        String sql = "insert into `t_book` values(?,?,?)";
        jdbcTemplate.update(sql, book.getUserId(), book.getUsername(), book.getUstatus());
    }

    @Override
    public void updateBook(Book book) {
        String sql = "update `t_book` set `username`=?,`ustatus`=? where `user_id`=?";
        jdbcTemplate.update(sql, book.getUsername(), book.getUstatus(), book.getUserId());
    }

    @Override
    public void deleteBook(String id) {
        String sql = "delete from `t_book` where `user_id`=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public int selectCount() {
        String sql = "select count(*) from `t_book`";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public Book findBookInfo(String id) {
        String sql = "select * from t_book where user_id=?";
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        return book;
    }

    @Override
    public List<Book> findAllBook() {
        String sql = "select * from t_book";
        List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return bookList;
    }

    @Override
    public void batchAddBook(List<Object[]> batchArgs) {
        String sql = "insert into `t_book` values(?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchUpdateBook(List<Object[]> batchArgs) {
        String sql = "update `t_book` set `username`=?,`ustatus`=? where `user_id`=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchDeleteBook(List<Object[]> batchArgs) {
        String sql = "delete from `t_book` where `user_id`=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }
}
