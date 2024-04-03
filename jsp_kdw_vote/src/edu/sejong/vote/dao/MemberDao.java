package edu.sejong.vote.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import edu.sejong.vote.vo.MemberVO;

public class MemberDao {

	// 커넥션 풀 객체
	private DataSource dataSource = null;

	public MemberDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oraclevote");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> list() {

		List<MemberVO> dtos = new ArrayList<MemberVO>();

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT a.*, b.p_name," + 
					"    case when a.p_school = '1' then '고졸'" + 
					"         when a.p_school = '2' then '학사'" + 
					"         when a.p_school = '3' then '석사'" + 
					"         when a.p_school = '4' then '박사'" + 
					"    end as t_school," + 
					" trim(b.p_tel1) || '-' || trim(b.p_tel2) || '-' || trim(b.p_tel3) as p_tel" +
					" FROM MEMBER a inner join PARTY b" + 
					" on a.p_code = b.p_code" + 
					" order by m_no"; 
			System.out.println("sql = " + sql);

			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				String m_no = rs.getString("m_no");
				String m_name = rs.getString("m_name");
				String p_code = rs.getString("p_code");
				String p_school = rs.getString("p_school");
				String m_jumin = rs.getString("m_jumin");
				String m_city = rs.getString("m_city");
				String p_name = rs.getString("p_name");
				String t_school = rs.getString("t_school");
				String p_tel = rs.getString("p_tel");

				MemberVO dto = new MemberVO(m_no, m_name, p_code, p_school, m_jumin, m_city, p_name, t_school, p_tel);
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
	
	public void write(String m_no, String m_name, String p_code, String p_school, String m_jumin, String m_city) {

		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			String sql = "insert into MEMBER (m_no, m_name, p_code, p_school, m_jumin, m_city) values (?, ?, ?, ?, ?, ?)";

			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, m_no);
			psmt.setString(2, m_name);
			psmt.setString(3, p_code);
			psmt.setString(4, p_school);
			psmt.setString(5, m_jumin);
			psmt.setString(6, m_city);

			int rn = psmt.executeUpdate();

			System.out.println("insert 된 갯수" + rn);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void modify(String m_no, String m_name, String p_code, String p_school, String m_jumin, String m_city) {

		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			String sql = "update MEMBER"
					+ " set m_name = ?,"
					+ " 	p_code = ?,"
					+ "		p_school = ?,"
					+ "		m_jumin = ?,"
					+ "		m_city = ?"
					+ " where m_no = ?";

			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, m_name);
			psmt.setString(2, p_code);
			psmt.setString(3, p_school);
			psmt.setString(4, m_jumin);
			psmt.setString(5, m_city);
			psmt.setString(6, m_no);

			int rn = psmt.executeUpdate();

			System.out.println("update 된 갯수" + rn);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public MemberVO memberView(String m_no) {

		MemberVO dto = null;

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from MEMBER where m_no = ?";
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, m_no);

			rs = psmt.executeQuery();

			if (rs.next()) {
				String k_no = rs.getString("m_no");
				String m_name = rs.getString("m_name");
				String p_code = rs.getString("p_code");
				String p_school = rs.getString("p_school");
				String m_jumin = rs.getString("m_jumin");
				String m_city = rs.getString("m_city");

				dto = new MemberVO(k_no, m_name, p_code, p_school, m_jumin, m_city);
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

		return dto;
	}
	
	public void delete(String m_no) {
		
		if(dataCheck(m_no) != "") {
			System.out.println("해당 후보에 투표한 유권자가 존재 - 삭제불가!!!");
			return;
		}

		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			String sql = "delete from MEMBER where m_no = ?";

			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, m_no);
			int rn = psmt.executeUpdate();

			System.out.println("삭제된 갯수:" + rn);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public String dataCheck(String m_no) {
		String chk_no = "";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			String sql = "select m_no from VOTE where m_no = ?";
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, m_no);

			rs = psmt.executeQuery();

			if (rs.next()) {
				chk_no = rs.getString("m_no");
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

		System.out.println("chk_no = " + chk_no);
		return chk_no;
	}
	
}