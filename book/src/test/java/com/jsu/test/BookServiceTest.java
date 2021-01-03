package com.jsu.test;

import com.jsu.pojo.Book;
import com.jsu.pojo.Page;
import com.jsu.service.BookService;
import com.jsu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceTest {

    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {

        bookService.addBook(new Book(null,"的精神","减肥的",new BigDecimal(12333),1000,1,null));

    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22,"牺牲的精神","小李",new BigDecimal(12333),1000,1,null));
    }

    @Test
    public void queryBookById() {
        bookService.queryBookById(22);
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);

        }
    }

    @Test
    public void page(){
        System.out.println(bookService.page(1, Page.PAGE_SIZE));
    }
    @Test
    public void pageByPrice(){
        System.out.println(bookService.pageByPrice(1, Page.PAGE_SIZE,10,50));
    }

}