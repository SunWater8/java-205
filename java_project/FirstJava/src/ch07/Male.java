package ch07;

class Male extends Person{
	String driveLi;
	Male(){}
	Male(String name, int personNum) {
		super(name, personNum);
	}
	
	public void driving() {
		System.out.println("그는 그의 차를 운전해서 퇴근하고 있다.");
	}
	public void greeting() {
		System.out.println("안녕하세요. 저는 김유신 입니다.");
	}
}