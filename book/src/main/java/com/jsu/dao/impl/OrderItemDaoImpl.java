package com.jsu.dao.impl;

import com.jsu.dao.OrderItemDao;
import com.jsu.pojo.Book;
import com.jsu.pojo.OrderItem;
import com.jsu.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        Connection conn= JdbcUtils.getConnection();
        PreparedStatement pstmt;
        ResultSet rs;
        List<Book> orderList=new ArrayList<Book>();
        String sql = "insert into t_order_item(name,count,price,total_price,order_id) values(?,?,?,?,?)";
        try {

            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,orderItem.getOrderId());
            pstmt.setInt(2, orderItem.getCount());
            pstmt.setBigDecimal(3,orderItem.getPrice());
            pstmt.setBigDecimal(4,orderItem.getTotalPrice());
            pstmt.setString(5,orderItem.getOrderId());
            pstmt.execute();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }



}