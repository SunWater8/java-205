package guest.domain;

public class MessageRequest {

	//이 변수를 이용해 use bean 만들 예정
	private String guestname;
	private String password;
	private String message;
	
	//parameter로 사용할 것이기 때문에 getter/setter 필요.
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
	
	
	@Override
	public String toString() {
		return "MessageRequest [guestname=" + guestname + ", password=" + password + ", message=" + message + "]";
	}
	//MessageRequest 에서 Message 객체 반환
	public Message toMessage() {
		return new Message(guestname, password, message);
	}
	
	
}
