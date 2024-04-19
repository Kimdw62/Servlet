package edu.sejong.game.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import edu.sejong.game.vo.BoardVO;

public class BoardDao {

	// Ä¿³Ø¼Ç Ç® °´Ã¼
	private DataSource dataSource = null;

	public BoardDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<BoardVO> list() {

		List<BoardVO> dtos = new ArrayList<BoardVO>();

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from mvc_board order by bgroup desc, bstep asc";
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");

				BoardVO dto = new BoardVO(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
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

	public void write(String bname, String btitle, String bcontent) {

		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			String sql = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values \r\n"
					+ "(mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0 )";

			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, bname);
			psmt.setString(2, btitle);
			psmt.setString(3, bcontent);

			int rn = psmt.executeUpdate();

			System.out.println("insert µÈ °¹¼ö" + rn);

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

	public BoardVO contentView(String bid) {

		BoardVO dto = null;

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from mvc_board where bid=?";
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, Integer.valueOf(bid));

			rs = psmt.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");

				dto = new BoardVO(id, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);

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

	public void delete(String bid) {

		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			String sql = "delete from mvc_board where bid = ? ";

			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, Integer.valueOf(bid));
			int rn = psmt.executeUpdate();

			System.out.println("»èÁ¦µÈ °¹¼ö:" + rn);

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

	public void modify(String bid, String bname, String btitle, String bcontent) {

		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			String sql = "update mvc_board set bname = ?, btitle = ?, bcontent = ? where bid = ?";

			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, bname);
			psmt.setString(2, btitle);
			psmt.setString(3, bcontent);
			psmt.setInt(4, Integer.valueOf(bid));

			int rn = psmt.executeUpdate();

			System.out.println("update µÈ °¹¼ö" + rn);

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

	public BoardVO replyView(String bid) {

		BoardVO dto = null;

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from mvc_board where bid=?";
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, Integer.valueOf(bid));

			rs = psmt.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");

				dto = new BoardVO(id, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);

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

	private void replyShape(String bgroup, String bstep) {
		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			String sql = "update mvc_board set bstep = bstep+1 where bgroup =? and bstep > ?";

			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, Integer.valueOf(bgroup));
			psmt.setInt(2, Integer.valueOf(bstep));

			int rn = psmt.executeUpdate();

			System.out.println("update step µÈ °¹¼ö" + rn);

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

	public void reply(String bid, String bname, String btitle, String bcontent, String bgroup, String bstep,
			String bindent) {

		replyShape(bgroup, bstep);

		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			String sql = "insert into mvc_board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) values \r\n"
					+ "(mvc_board_seq.nextval, ?, ?, ?, ?, ?, ? )";

			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, bname);
			psmt.setString(2, btitle);
			psmt.setString(3, bcontent);

			psmt.setInt(4, Integer.valueOf(bgroup));
			psmt.setInt(5, Integer.valueOf(bstep) + 1);
			psmt.setInt(6, Integer.valueOf(bindent) + 1);

			int rn = psmt.executeUpdate();

			System.out.println("insert µÈ °¹¼ö" + rn);

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

	public void upHit(String bid) {
		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			String sql = "update mvc_board set bhit = bhit +1 where bid=?";

			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, Integer.valueOf(bid));

			int rn = psmt.executeUpdate();

			System.out.println("update bhit °¹¼ö" + rn);

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

}