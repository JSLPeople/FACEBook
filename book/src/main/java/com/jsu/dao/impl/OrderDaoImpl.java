package com.jsu.dao.impl;

import com.jsu.dao.OrderDao;
import com.jsu.pojo.Book;
import com.jsu.pojo.Order;
import com.jsu.utils.JdbcUtils;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        Connection conn= JdbcUtils.getConnection();
        PreparedStatement pstmt;
        ResultSet rs;
        List<Book> orderList=new ArrayList<Book>();
        String sql = "insert into t_order(order_id,create_time,price,status,user_id) values(?,?,?,?,?)";
        try {
            //先将字符日期转为util日期


            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,order.getOrderId());
            pstmt.setDate(2, new java.sql.Date(order.getCreateTime().getTime()) );
            pstmt.setBigDecimal(3,order.getPrice());
            pstmt.setInt(4,order.getStatus());
            pstmt.setInt(5,order.getUserId());
            pstmt.execute();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }
}