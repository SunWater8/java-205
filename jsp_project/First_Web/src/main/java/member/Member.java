package member;

//빈즈 클래스 생성
public class Member {

	//변수는 모두 private 처리
	private String id;
	private String pw;
	private String name;
	
	public Member() {} //생성자는 기본으로 하기 - beans 클래스는 기본 생성자 필수
	
	
	//setter 와 getter
	public void setId(String id) {
		this.id=id; //this는 자기 자신을 참조하는 참조변수
	}
	public String getId() {
		return id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPw() {
		return pw;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}


	
}
