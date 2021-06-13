package ex.ex02Inheritance.informanager;

public class HighFriend extends Friend{
	//고교 친구는 직장 정보를 추가적으로 가진다.
	String work;
	public HighFriend(String name, String phoneNum, String address,String work) {
		super(name, phoneNum, address);
		this.work=work;
	}
	
	@Override
	public void showData() {
		super.showData();
		System.out.println("직업 : "+work);
	}

	@Override
	public void showBasicInfo() {
		System.out.println("이름 : "+name);
		System.out.println("전화 : "+phoneNum);
	}


	


}
