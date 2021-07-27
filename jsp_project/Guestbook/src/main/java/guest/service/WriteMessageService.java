package guest.service;

import java.sql.Connection;
import java.sql.SQLException;

import guest.dao.MessageDao;
import guest.domain.Message;
import guest.domain.MessageRequest;
import guest.jdbc.ConnectionProvider;
import guest.jdbc.JdbcUtil;

public class WriteMessageService {
	
	//싱글톤 패턴
	private WriteMessageService() {}
	private static WriteMessageService service = new WriteMessageService();
	public static WriteMessageService getInstance() {
		return service;
	}
	
	
	//메시지를 DB에 쓰고 처리된 결과를 생성한다. 
	public int writeMessage(MessageRequest requestMessage) {
		int resultCnt = 0;
		
		//트랜젝션 처리를 위해서 Connection 생성
		Connection conn = null;
		MessageDao dao = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MessageDao.getInstance();
			
			//autoCommit의 기본값은 true이기 때문에 자동커밋이 된다. 
			//프로그래머가 Java JDBC에서 트랜젝션을 컨트롤 하기 위해 false라고 입력한다.  
			//spring, 마이바티즈에서는 이런 식의 트랜젝션 세팅을 하지는 않는다. 
			conn.setAutoCommit(false);
			
			//Message 객체 들어가기 . 
			Message message = requestMessage.toMessage();
			//데이터 전처리가 필요한 부분은 처리
			// ...
			// ...
			// ...
			
			
			resultCnt = dao.writeMessage(conn, message);
			
			//트랜젝션 완료.
			conn.commit();
		} catch (SQLException e) {
			//트랜젝션 rollback
			 JdbcUtil.rollback(conn);
			 
			e.printStackTrace(); //오류가 발생한 원인을 알기 위해 꼭 써주도록 하기
		}
		
		return resultCnt;
	}
}
