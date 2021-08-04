package member.domain;

public class RegRequest {

	//사용자가 입력하는 변수들
	private String email;
	private String password;
	private String confirmPassword;
	private String name;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//비밀번호와 비밀번호확인과 일치하는지에 대한 여부 확인하기 (논리값을 얻을 때는 메소드 이름 앞에 get이 아닌 is을 붙인다.)
	public boolean isPasswordEqualToConfirmPassword() {
		
		return password.equals(confirmPassword);
	}
}
