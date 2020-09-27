package com.itoffer.lmx.db;

import java.sql.*;

public class jdbc {
    public static void main(String[] args) throws Exception {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?useSSL=FALSE&serverTimezone=UTC", "root", "root");

        //添加1条记录
        String sql1 = "insert into student(name,age) values(?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql1);
        pstmt.setString(1, "lmx");
        pstmt.setInt(2, 22);
        pstmt.executeUpdate();

        //查询记录
        String sql2 = "select * from student";
        pstmt = conn.prepareStatement(sql2);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            String name = rs.getString("name");
            int age = rs.getInt("age");
            System.out.println("name=" + name + ",age=" + age);
        }
        rs.close();
        //修改记录
        String sql3 = "update student set name=? where id=1";
        pstmt = conn.prepareStatement(sql3);
        pstmt.setString(1, "lmxnew");
        pstmt.executeUpdate();

        //查询记录
        System.out.println("修改后的表如下：");
        pstmt = conn.prepareStatement(sql2);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            String name = rs.getString("name");
            int age = rs.getInt("age");
            System.out.println("name=" + name + ",age=" + age);
        }

        //释放资源
        rs.close();
        conn.close();
        pstmt.close();
    }
}
