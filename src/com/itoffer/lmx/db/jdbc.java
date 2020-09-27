package com.itoffer.lmx.db;

import java.sql.*;

public class jdbc {
    public static void main(String[] args) throws Exception {
        //ע������
        Class.forName("com.mysql.cj.jdbc.Driver");
        //��ȡ����
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?useSSL=FALSE&serverTimezone=UTC", "root", "root");

        //���1����¼
        String sql1 = "insert into student(name,age) values(?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql1);
        pstmt.setString(1, "lmx");
        pstmt.setInt(2, 22);
        pstmt.executeUpdate();

        //��ѯ��¼
        String sql2 = "select * from student";
        pstmt = conn.prepareStatement(sql2);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            String name = rs.getString("name");
            int age = rs.getInt("age");
            System.out.println("name=" + name + ",age=" + age);
        }
        rs.close();
        //�޸ļ�¼
        String sql3 = "update student set name=? where id=1";
        pstmt = conn.prepareStatement(sql3);
        pstmt.setString(1, "lmxnew");
        pstmt.executeUpdate();

        //��ѯ��¼
        System.out.println("�޸ĺ�ı����£�");
        pstmt = conn.prepareStatement(sql2);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            String name = rs.getString("name");
            int age = rs.getInt("age");
            System.out.println("name=" + name + ",age=" + age);
        }

        //�ͷ���Դ
        rs.close();
        conn.close();
        pstmt.close();
    }
}
