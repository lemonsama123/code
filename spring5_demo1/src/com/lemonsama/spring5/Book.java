package com.lemonsama.spring5;

public class Book {

    private String bname;

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Book(String bname) {
        this.bname = bname;
    }

    public static void main(String[] args) {
        Book book = new Book("abc");
//        book.setBname("abc");
        System.out.println(book.bname);
    }
}
