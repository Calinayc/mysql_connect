package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
	// write your code here
        String[] tables = new String[100];
        String[] len = new String[100];
        int t = 0;
        //读取配置文件
        InputStream is = Main.class.getClassLoader().getResourceAsStream("conf.properties");
        //创建Properties对象
        Properties pro = new Properties();
        //装载
        pro.load(is);

        //注册驱动
        String driver = pro.getProperty("driver");
        Class.forName(driver);
        //获取连接
        String url = pro.getProperty("url");
        String user = pro.getProperty("user");
        String pwd = pro.getProperty("pwd");
        System.out.println("连接数据库");
        Connection conn = DriverManager.getConnection(url,user,pwd);
        System.out.println(conn);

        //执行查询
        System.out.println("实例化Statement对象");
        Statement stmt = conn.createStatement();
        Statement qq = conn.createStatement();
        Statement ww = conn.createStatement();
        String sql;
        sql = "show tables";
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()){
	    System.out.println("查询表结果");
            System.out.println(rs.getString("Tables_in_yctest"));
            }
        rs.close();
        stmt.close();
        conn.close();

    }
}
