package com.jsu.test;

import com.jsu.dao.BookDao;
import com.jsu.dao.impl.BookDaoImpl;
import com.jsu.pojo.Book;
import com.jsu.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"朝花夕拾","鲁迅",new BigDecimal(39.9),111222,0,null));

    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21,"骆驼祥子","luxun",new BigDecimal(39.9),88922,0,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        for(Book queryBook : bookDao.queryBooks()){
            System.out.println(queryBook);
        }
    }
    @Test
    public void queryForPageTotalCount() {
        System.out.println( bookDao.queryForPageTotalCount() );
    }

    @Test
    public void queryForPageItems() {
        for (Book book : bookDao.queryForPageItems(1, Page.PAGE_SIZE)) {
            System.out.println(book);

        }
    }
    @Test
    public void queryForPageTotalCountByPrice() {

        System.out.println( bookDao.queryForPageTotalCountByPrice(40,90) );
    }

    @Test
    public void queryForPageItemsByPrice() {
        for (Book book : bookDao.queryForPageItemsByPrice(0, Page.PAGE_SIZE,10,50)) {
            System.out.println(book);

        }
    }
}