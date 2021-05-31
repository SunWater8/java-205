package ex.informanager2;

public class UnivFriend extends Friend{
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

	@Override  
	public void showBasicInfo() {
//		super.showBasicInfo();
		System.out.println("이름 : "+name);
		System.out.println("전화 : "+phoneNum);
		System.out.println("전공 : "+ major);
	}
}
