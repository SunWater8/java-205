package guest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import guest.domain.Message;
import guest.jdbc.JdbcUtil;

public class MessageDao {
	// 싱글톤 처리
	private MessageDao() {
	}

	private static MessageDao dao = new MessageDao();

	// 반환 메소드
	public static MessageDao getInstance() {
		return dao;
	}

	// sql에서 insert into
	public int writeMessage(Connection conn, Message message) throws SQLException {

		int resultCnt = 0;
		PreparedStatement pstmt = null;

		String sql = "insert into guestbook_message (guestname, password, message) values(?, ?, ?);";

		try {
			pstmt = conn.prepareStatement(sql); // SQLException 예외는 service에서 처리하도록 하기
			pstmt.setString(1, message.getGuestname());
			pstmt.setString(2, message.getPassword());
			pstmt.setString(3, message.getMessage());
			resultCnt = pstmt.executeUpdate();
		} finally {
			// close 처리
			JdbcUtil.close(pstmt);
		}
		return resultCnt;
	}

	// 전체 게시물의 개수
	public int selectAllCount(Connection conn) throws SQLException {
		int totalCount = 0;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql = "select count(*) from project.guestbook_message";
			rs = stmt.executeQuery(sql);
			if (rs != null) {
				totalCount = rs.getInt(1);
			}
		} finally {
			JdbcUtil.close(stmt);
			JdbcUtil.close(rs);
		}

		return totalCount;
	}

	// 요청 페이지에 표현할 메시지 리스트 구하기
	public List<Message> selectMessageList(Connection conn, int firstRow, int messageCountPerPage) throws SQLException {
		List<Message> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from project.guestbook_message order by regdate desc limit ?, ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, firstRow);
			pstmt.setInt(2, messageCountPerPage);
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList<Message>();
			while(rs.next()) {
				list.add(new Message(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getTimestamp(5)));
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

		return null;
	}

}
