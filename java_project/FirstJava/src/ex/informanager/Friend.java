package ex.informanager;

//상속을 목적으로 하는 클래스
public class Friend {
	//이름, 전화번호, 주소 변수 선언하기 - 가장 기본 적인 정보는 상위클래스에서 선언을 해준다.
	String name;
	String phoneNum;
	String address;
	
	public Friend(String name, String phoneNum, String address) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
		this.address = address;
	}

	 public void showData() {
		 System.out.println("이름 : "+name);
		 System.out.println("전화 : "+phoneNum);
		 System.out.println("주소 : "+address);
	 }
	 
	 public void showBasicInfo() {} //하위 클래스에서 각자 내용에 맞게 오버라이딩 하기 위해 빈 칸으로 남겨 둠.
	
}
