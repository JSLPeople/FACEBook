package com.jsu.dao.impl;

import com.jsu.dao.BookDao;
import com.jsu.pojo.Book;
import com.jsu.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BookDaoImpl extends BaseDao implements BookDao {


    @Override
    public int addBook(Book book) {
        Connection conn= JdbcUtils.getConnection();
        PreparedStatement pstmt;
        ResultSet rs;
        List<Book> bookList=new ArrayList<Book>();
        int r= (int) (Math.random()*(100-1)+1);
        String imgAddress1 = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fdpic.tiankong.com%2Fnn%2F05%2FQJ8718664175.jpg&refer=http%3A%2F%2Fdpic.tiankong.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1612165926&t=c5bb08d390029e3573947dc7c2787d64";
        String imgAddress2 = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fbig5.wallcoo.com%2Fcartoon%2FVladstudio_high_quality_widescreen_wallpaper_1920x1200_02%2Fimages%2F002_vladstudio_googlelibrary.jpg&refer=http%3A%2F%2Fbig5.wallcoo.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1612165926&t=aa3b3e56da0b43a647d5cc477d6b8d0a";
        String imgAddress3 = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.article.pchome.net%2F01%2F60%2F15%2F05%2Fpic_lib%2Fs960x639%2Ftushuguan12s960x639.jpg&refer=http%3A%2F%2Fimg.article.pchome.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1612165926&t=967781c883098a2b7f42ec96764429bc";
        String imgAddress4 = "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3865588184,3342697262&fm=26&gp=0.jpg";
        String sql = "insert into t_book(name,author,price,sales,stock,img_path) value(?,?,?,?,?,?)";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,book.getName());
            pstmt.setString(2,book.getAuthor());
            pstmt.setBigDecimal(3,book.getPrice());
            pstmt.setInt(4,book.getSales());
            pstmt.setInt(5,book.getStock());
            if(r>=75){
                pstmt.setString(6,imgAddress4);
            } else if(r<=25){
                pstmt.setString(6,imgAddress1);
            } else if(r<=50&&r>25){
                pstmt.setString(6,imgAddress2);
            } else{
                pstmt.setString(6,imgAddress3);
            }
            pstmt.execute();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteBookById(Integer id) {
        Connection conn= JdbcUtils.getConnection();
        PreparedStatement pstmt;
        ResultSet rs;
        List<Book> bookList=new ArrayList<Book>();

        String sql = "delete from t_book where id = ?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.execute();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateBook(Book book) {
        Connection conn= JdbcUtils.getConnection();
        PreparedStatement pstmt;
        ResultSet rs;
        List<Book> bookList=new ArrayList<Book>();
        int r= (int) (Math.random()*(100-1)+1);
        String imgAddress1 = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fdpic.tiankong.com%2Fnn%2F05%2FQJ8718664175.jpg&refer=http%3A%2F%2Fdpic.tiankong.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1612165926&t=c5bb08d390029e3573947dc7c2787d64";
        String imgAddress2 = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fbig5.wallcoo.com%2Fcartoon%2FVladstudio_high_quality_widescreen_wallpaper_1920x1200_02%2Fimages%2F002_vladstudio_googlelibrary.jpg&refer=http%3A%2F%2Fbig5.wallcoo.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1612165926&t=aa3b3e56da0b43a647d5cc477d6b8d0a";
        String imgAddress3 = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.article.pchome.net%2F01%2F60%2F15%2F05%2Fpic_lib%2Fs960x639%2Ftushuguan12s960x639.jpg&refer=http%3A%2F%2Fimg.article.pchome.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1612165926&t=967781c883098a2b7f42ec96764429bc";
        String imgAddress4 = "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3865588184,3342697262&fm=26&gp=0.jpg";
        String sql = "update t_book set name = ?,author = ?,price = ?,sales = ?,stock = ?,img_path = ? where id = ?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,book.getName());
            pstmt.setString(2,book.getAuthor());
            pstmt.setBigDecimal(3,book.getPrice());
            pstmt.setInt(4,book.getSales());
            pstmt.setInt(5,book.getStock());
            if(r>=75){
                pstmt.setString(6,imgAddress4);
            } else if(r<=25){
                pstmt.setString(6,imgAddress1);
            } else if(r<=50&&r>25){
                pstmt.setString(6,imgAddress2);
            } else{
                pstmt.setString(6,imgAddress3);
            }

            pstmt.setInt(7,book.getId());
            pstmt.execute();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Book queryBookById(Integer id) {
        Connection conn= JdbcUtils.getConnection();
        PreparedStatement pstmt;
        ResultSet rs;
        Book book=new Book();
        String sql = "select id, name,author,price,sales,stock,img_path from t_book where id = ?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs=pstmt.executeQuery();
            while(rs.next()){
                book=new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getBigDecimal(4),rs.getInt(5),rs.getInt(6),rs.getString(7));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public List<Book> queryBooks() {
        Connection conn= JdbcUtils.getConnection();
        Statement stam=null;
        String sql;
        ResultSet rs;
        List<Book> bookList=new ArrayList<Book>();
        try{
            stam=conn.createStatement();
            sql="select * from t_book ";
            rs=stam.executeQuery(sql);
            while(rs.next()){
                bookList.add(new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getBigDecimal(4),rs.getInt(5),rs.getInt(6),rs.getString(7)));
            }
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        Connection conn= JdbcUtils.getConnection();
        PreparedStatement pstmt;
        ResultSet rs;
        List<Book> bookList=new ArrayList<Book>();
        String sql = "select id, name,author,price,sales,stock,img_path  from t_book limit ?,?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,begin);
            pstmt.setInt(2,pageSize);
            rs=pstmt.executeQuery();
            while(rs.next()){
                bookList.add(new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getBigDecimal(4),rs.getInt(5),rs.getInt(6),rs.getString(7)));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number count = (Number) queryForSingleValue(sql,min,max);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        Connection conn= JdbcUtils.getConnection();
        PreparedStatement pstmt;
        ResultSet rs;
        List<Book> bookList=new ArrayList<Book>();
        String sql = "select id, name,author,price,sales,stock,img_path from t_book where price between ? and ? order by price limit ?,? ";
        try {
            pstmt= conn.prepareStatement(sql);
            pstmt.setInt(1,min);
            pstmt.setInt(2,max);
            pstmt.setInt(3,begin);
            pstmt.setInt(4,pageSize);
            rs=pstmt.executeQuery();//执行查询语句
            while(rs.next()){
                bookList.add(new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getBigDecimal(4),rs.getInt(5),rs.getInt(6),rs.getString(7)));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }
}
