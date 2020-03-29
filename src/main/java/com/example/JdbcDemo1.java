package com.example;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Author ryan.xu
 * @since 2020/3/29
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws  Exception{
        //1.注册驱动
        DriverManager.registerDriver(new Driver());
        //2.获取连接
        Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy","root","123456");
        //3.获取查询与对象
        PreparedStatement psm = cnn.prepareStatement("select * from ");
        ResultSet rs = psm.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString("123"));
        }
        rs.close();
        psm.close();
        cnn.close();
    }
}
