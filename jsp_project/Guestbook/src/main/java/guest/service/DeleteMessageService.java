package guest.service;

import java.sql.Connection;
import java.sql.SQLException;

import guest.dao.MessageDao;
import guest.domain.Message;
import guest.exception.InvalidPasswordException;
import guest.exception.MessageNotFoundException;
import guest.jdbc.ConnectionProvider;
import guest.jdbc.JdbcUtil;

public class DeleteMessageService {

	// 싱글톤
	private DeleteMessageService() {
	}

	private static DeleteMessageService service = new DeleteMessageService();

	public static DeleteMessageService getInstance() {
		return service;
	}

	// 서비스 통해서 지워야 하는 메소드
	public int deleteMessage(int mid, String pw) throws SQLException, MessageNotFoundException, InvalidPasswordException   {
		int resultCnt = 0;

		Connection conn = null;
		MessageDao dao = null;
		try {
			conn = ConnectionProvider.getConnection(); // 예외 발생한 것을 jsp에서 처리하도록 하기
			dao = MessageDao.getInstance();
			
			//트랜젝션 시작 - select 의 문제가 생겨서 손 써볼 시간 없이 delete 될 수 있기 때문에 트랜젝션 만들기
			conn.setAutoCommit(false);
			//전달 받은 mid로 게시물을 검색하기.
			Message message = dao.selectByMid(conn, mid);
			if(message == null) { //게시물이 없을 때.
				throw new MessageNotFoundException(mid); 
			}else { //게시물이 있을 떄
				if(message.getPassword().equals(pw)) {
					//비밀번호와 일치하면 삭제하기
					resultCnt = dao.deleteMessage(conn, mid);
					
					//트랜젝션 성공
					conn.commit();
				}else { //비밀번호가 일치하지 않을 떄 예외처리
					throw new InvalidPasswordException();
				}
			}
		}catch(SQLException  e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
			throw e;
		}catch(MessageNotFoundException e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
			throw e;
		}catch(InvalidPasswordException e){
			e.printStackTrace();
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}

		return resultCnt;
	}
}
