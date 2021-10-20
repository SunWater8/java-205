package member.domain;

import java.util.Date;

public class Member {

	private int id;
	private String email;
	private String password;
	private String name;
	private Date registDate;
	
	//사용자가 입력하는 것:email, 비밀번호, 이름
	public Member(int id, String email, String password, String name, Date registDate) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.registDate = registDate;
	}

	//저장된 데이터를 가져올 목적으로 get 만 만들기	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}

	public String getEmail() {
		return email;
	}


	public String getPassword() {
		return password;
	}


	public String getName() {
		return name;
	}


	public Date getRegistDate() {
		return registDate;
	}
	
		
	//비밀번호 변경 메소드
	//사용자로부터 받은 비밀번호는 oldPw, 바꾸는 비밀번호는  newPw
	public void changePassword(String oldPw, String newPw) throws Exception {
		
		if(password.equals(oldPw)) {
			//비밀번호가 일치하면 새 비밀번호를 만들도록 하고
			password = newPw;
		}else {
			throw new Exception("비밀번호 불일치");
		}
	}
	
}
