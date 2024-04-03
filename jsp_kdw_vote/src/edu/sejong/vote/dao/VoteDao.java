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
import edu.sejong.vote.vo.VoteVO;

public class VoteDao {

	// 커넥션 풀 객체
	private DataSource dataSource = null;

	public VoteDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oraclevote");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<VoteVO> list() {

		List<VoteVO> dtos = new ArrayList<VoteVO>();

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT a.v_name, a.v_jumin as u_jumin,\r\n" + 
					"    '19' || substr(a.v_jumin, 1, 2) || '년' || substr(a.v_jumin, 3, 2) || '월' || substr(a.v_jumin, 5, 2) || '일생' as v_jumin,\r\n" + 
					"    '만 ' || to_char(2024 - (1900 + to_number(substr(a.v_jumin, 1, 2)))) || '세' as v_age,\r\n" + 
					"    case when substr(a.v_jumin, 7, 1) = '1' then '남' else '여' end as v_sex,\r\n" + 
					"    b.m_no || '.' || b.m_name as m_no,\r\n" + 
					"    substr(a.v_time, 1, 2) || ':' || substr(a.v_time, 3, 2) as v_time,\r\n" + 
					"    case when a.v_confirm = 'Y' then '확인' else '미확인' end as v_confirm\r\n" + 
					" FROM VOTE a inner join MEMBER b\r\n" + 
					" on a.m_no = b.m_no"; 
			System.out.println("sql = " + sql);

			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				String v_name = rs.getString("v_name");
				String v_jumin = rs.getString("v_jumin");
				String u_jumin = rs.getString("u_jumin");
				String v_age = rs.getString("v_age");
				String v_sex = rs.getString("v_sex");
				String m_no = rs.getString("m_no");
				String v_time = rs.getString("v_time");
				String v_confirm = rs.getString("v_confirm");

				VoteVO dto = new VoteVO(v_name, v_jumin, v_age, v_sex, m_no, v_time, v_confirm, u_jumin);
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

	public List<VoteVO> rank() {

		List<VoteVO> dtos = new ArrayList<VoteVO>();

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT a.m_no, b.m_name as v_name, count(*) as v_count\r\n" + 
					" FROM VOTE a inner join MEMBER b\r\n" + 
					" ON a.m_no = b.m_no\r\n" + 
					" where a.v_confirm = 'Y' \r\n" + 
					" group by a.m_no, b.m_name\r\n" + 
					" order by count(*) desc"; 
			System.out.println("sql = " + sql);

			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			
			while (rs.next()) {
				String m_no = rs.getString("m_no");
				String v_name = rs.getString("v_name");
				String v_count = rs.getString("v_count");

				VoteVO dto = new VoteVO(m_no, v_name, v_count);
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
	
	public void write(String v_jumin, String v_name, String m_no, String v_time, String v_area, String v_confirm) {

		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			String sql = "insert into VOTE (v_jumin, v_name, m_no, v_time, v_area, v_confirm) values (?, ?, ?, ?, ?, ?)";

			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, v_jumin);
			psmt.setString(2, v_name);
			psmt.setString(3, m_no);
			psmt.setString(4, v_time);
			psmt.setString(5, v_area);
			psmt.setString(6, v_confirm);

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

	public void modify(String v_jumin, String v_name, String m_no, String v_time, String v_area, String v_confirm) {

		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			String sql = "update VOTE"
					+ " set v_name = ?,"
					+ " 	m_no = ?,"
					+ "		v_time = ?,"
					+ "		v_area = ?,"
					+ "		v_confirm = ?"
					+ " where v_jumin = ?";

			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, v_name);
			psmt.setString(2, m_no);
			psmt.setString(3, v_time);
			psmt.setString(4, v_area);
			psmt.setString(5, v_confirm);
			psmt.setString(6, v_jumin);

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
	
	public VoteVO voteView(String v_jumin) {

		VoteVO dto = null;

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from VOTE where v_jumin = ?";
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, v_jumin);

			rs = psmt.executeQuery();

			if (rs.next()) {
				String k_jumin = rs.getString("v_jumin");
				String v_name = rs.getString("v_name");
				String m_no = rs.getString("m_no");
				String v_time = rs.getString("v_time");
				String v_area = rs.getString("v_area");
				String v_confirm = rs.getString("v_confirm");

				dto = new VoteVO(k_jumin, v_name, m_no, v_time, v_area, v_confirm);
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
	
}