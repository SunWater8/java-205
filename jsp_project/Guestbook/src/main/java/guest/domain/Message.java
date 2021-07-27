package guest.domain;

import java.sql.Timestamp;
//dao에 이 포맷에 맞추어 보낼 예정
public class Message {
	//db 의 변수를 그대로 사용해야 한다.
	private int messageid;
	private String guestname;
	private String password;
	private String message;
	private Timestamp regdate;
	
	//default 생성자
	public Message() {
	}

	//모든 변수 생성자
	public Message(int messageid, String guestname, String password, String message, Timestamp regdate) {
		super();
		this.messageid = messageid;
		this.guestname = guestname;
		this.password = password;
		this.message = message;
		this.regdate = regdate;
	}

	//메시지 사용에 필요한 위한 생성자
	public Message(String guestname, String password, String message) {
		super();
		this.guestname = guestname;
		this.password = password;
		this.message = message;
	}

	
	//getter/setter
	public int getMessageid() {
		return messageid;
	}

	public void setMessageid(int messageid) {
		this.messageid = messageid;
	}

	public String getGuestname() {
		return guestname;
	}

	public void setGuestname(String guestname) {
		this.guestname = guestname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Message [messageid=" + messageid + ", guestname=" + guestname + ", password=" + password + ", message="
				+ message + ", regdate=" + regdate + "]";
	}
	
	
	
	
	
	
	
}
