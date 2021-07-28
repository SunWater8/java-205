package guest.exception;

public class MessageNotFoundException extends Exception{

	public MessageNotFoundException(int mid) {
		super(mid+"번 게시물이 존재하지 않습니다.");
	}

}
