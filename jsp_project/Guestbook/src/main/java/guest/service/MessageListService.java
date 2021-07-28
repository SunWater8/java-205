package guest.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import guest.dao.MessageDao;
import guest.domain.Message;
import guest.domain.MessageListView;
import guest.jdbc.ConnectionProvider;

public class MessageListService {
	
	//3. 한 페이지에 표현할 메시지의 개수
	private final int messageCountPerPage = 3;
	
	//2. 싱글톤
	private MessageListService() {}
	private static MessageListService service = new MessageListService();
	public static MessageListService getInstance() {
		return service;
	}
	
	//1. 메소드 만들기
	public MessageListView getMessageList(int pageNumber) {
		MessageListView listView = null;

		Connection conn = null;
		MessageDao dao =null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MessageDao.getInstance();
			
			// 전체 게시물의 개수
			int totalMessageCount = dao.selectAllCount(conn);
			System.out.println("totalMessageCount : "+totalMessageCount);
			
			//4. 페이지에 표현할 메시지 객체들 List<Message>
			List<Message> messageList = null;
			
			//firstRow 는 0부터 시작한다. - DB의 시작행의 위치값. DB에서 limit의 index에 해당.
			int firstRow =  (pageNumber-1)*messageCountPerPage;
			
			messageList = dao.selectMessageList(conn, firstRow, messageCountPerPage);
			System.out.println("message List : "+ messageList);
			
			listView = new MessageListView(messageList, totalMessageCount, pageNumber, messageCountPerPage, firstRow, firstRow)
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listView;
	}
}

//MessagelistView.java 의 변수를 가지가 값을 구하기