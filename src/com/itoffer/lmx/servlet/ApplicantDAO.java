package com.itoffer.lmx.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class ApplicantDAO {
	//验证email是否已经被注册
	public boolean isExistEmail(String email) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from TB_APPLICANT where APPLICANT_EMAIL = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return false;
	}
	//求职者信息注册保存
	public void save(String email, String password) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into TB_APPLICANT(APPLICANT_EMAIL,APPLICANT_PWD,APPLICANT_REGISTDATE) values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			pstmt.setTimestamp(3, new Timestamp(new Date().getTime()));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
	}
	public int login(String email, String password) {
		int applicantID = 0;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select APPLICANT_ID from TB_APPLICANT where APPLICANT_EMAIL = ? and APPLICANT_PWD = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				applicantID = rs.getInt("APPLICANT_ID");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			DBUtil.closeJDBC(rs, pstmt, conn);
		}
		return applicantID;
		
	}
	
}
