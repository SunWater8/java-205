package ex.informanager3_ArrayCollection;

public  class HighFriend extends Friend{
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
	public void showBasicInfo() {//메소드 문법에 맞게 중괄호만 써주어도 된다.
		System.out.println("이름 : "+name);
		System.out.println("전화 : "+phoneNum);
	}


	


}
