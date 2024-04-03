package edu.sejong.vote.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import edu.sejong.vote.vo.CodeVO;

public class CodeDao {

	// Ä¿³Ø¼Ç Ç® °´Ã¼
	private DataSource dataSource = null;

	public CodeDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oraclevote");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<CodeVO> party() {

		List<CodeVO> dtos = new ArrayList<CodeVO>();

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT p_code, p_name, p_reader FROM PARTY ORDER BY p_code"; 
			System.out.println("sql = " + sql);

			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				String p_code = rs.getString("p_code");
				String p_name = rs.getString("p_name");
				String p_reader = rs.getString("p_reader");

				CodeVO dto = new CodeVO(p_code, p_name, p_reader);
				dtos.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
	public List<CodeVO> school() {

		List<CodeVO> dtos = new ArrayList<CodeVO>();

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT p_school, t_school FROM SCHOOL ORDER BY p_school"; 
			System.out.println("sql = " + sql);

			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				String p_school = rs.getString("p_school");
				String t_school = rs.getString("t_school");

				CodeVO dto = new CodeVO(p_school, t_school);
				dtos.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}

	public List<CodeVO> area() {

		List<CodeVO> dtos = new ArrayList<CodeVO>();

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT v_area FROM AREA ORDER BY v_area"; 
			System.out.println("sql = " + sql);

			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				String v_area = rs.getString("v_area");

				CodeVO dto = new CodeVO(v_area);
				dtos.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
	
}