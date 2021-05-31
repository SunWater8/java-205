package ex.informanager2;

abstract public class Friend implements ShowData {//여기에도 abstract 포시하기 > 인터페이스 상속하기.
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
	 
//	 public void showBasicInfo() {} //
//	 public abstract void showBasicInfo();//추상메소드로 만들기 > 인터페이스로 이동
}
