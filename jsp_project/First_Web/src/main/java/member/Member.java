//package member;
//
////빈즈 클래스 생성
//public class Member {
//
//	//변수는 모두 private 처리
//	private String id;
//	private String pw;
//	private String name;
//	
//	 //생성자는 기본으로 하기 - beans 클래스는 기본 생성자 필수
//	public Member() {}
//	
//	//default 생성자 없이 다른 생성자로 실행해보기 -> 오류 남
////	public Member(String name) {}
//	
//	public Member(String id, String pw, String name) {
//		this.id=id;
//		this.pw=pw;
//		this.name=name;
//	}
//	
//	
//	//setter 와 getter
//	public void setId(String id) {
//		this.id=id; //this는 자기 자신을 참조하는 참조변수
//	}
//	public String getId() {
//		return id;
//	}
//
//	public void setPw(String pw) {
//		this.pw = pw;
//	}
//	public String getPw() {
//		return pw;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//
//	@Override
//	public String toString() {
//		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + "]";
//	}
//
//
//	
//}

package member;


// 빈즈 클래스 생성
public class Member {

	// 변수는 모두 private 처리
	private String id;
	private String pw;
	private String name;
	
	// beans 클래스는 기본 생성자 필수
	public Member(){}
	
	public Member(String id, String pw, String name){
		this.id=id;
		this.pw=pw;
		this.name=name;
	}	
	
	public Member(String name){}	
	
	// setter
	public void setId(String id) {
		this.id = id;
	}
	
	// getter
	public String getId() {
		return this.id;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getPw() {
		return this.pw;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}
	
	
	
	
}

