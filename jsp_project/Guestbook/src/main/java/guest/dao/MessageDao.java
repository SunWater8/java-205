package guest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import guest.domain.Message;
import guest.domain.MessageRequest;
import guest.jdbc.JdbcUtil;

public class MessageDao {
	//싱글톤 처리
	private MessageDao() {} 
	private static MessageDao dao = new MessageDao();
	//반환 메소드
	public static MessageDao getInstance() {
		return dao;
	}
	

	//sql에서 insert into
	public int writeMessage(Connection conn, Message message) throws SQLException {
		
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		
		String sql = "insert into guestbook_message (guestname, password, message) values(?, ?, ?);";
		
		try {
			pstmt = conn.prepareStatement(sql); //SQLException 예외는 service에서 처리하도록 하기
			pstmt.setString(1, message.getGuestname());
			pstmt.setString(2, message.getPassword());
			pstmt.setString(3, message.getMessage());
			resultCnt = pstmt.executeUpdate();
		}finally {
			//close 처리
			JdbcUtil.close(pstmt);
		}
		return resultCnt;
	}

}
