package ex.ex02Inheritance.informanager;

public class UnivFriend extends Friend{
	// 전공 학과 추가
	String major;

	public UnivFriend(String name, String phoneNum, String address,String work) {
		super(name, phoneNum, address);
		this.major=work;
	}

	@Override
	public void showData() {
		super.showData();
		System.out.println("전공 : "+major);
	}

	@Override  //이 annotation 표시 없으면 메소드의 선언부에 오타가 나도 빨간줄로 알려주지 않음. 그렇기 이 표시를 때문에 써주면 좋다. 
	public void showBasicInfo() {
		super.showBasicInfo();
		System.out.println("이름 : "+name);
		System.out.println("전화 : "+phoneNum);
		System.out.println("전공 : "+ major);
	}
}
