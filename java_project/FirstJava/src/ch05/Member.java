package ch05;

public class Member {
	String name;
	String phoneNum;
	String major;
	int level;
	String email;
	String birthday;
	String address;
	
	Member(String name,	String phoneNum, String major, int level, String email, 
			String birthday, String address){
		this.name=name;
		this.phoneNum=phoneNum;
		this.major=major;
		this.level=level;
		this.email=email;
		this.birthday=birthday;
		this.address=address;
	}
	Member(String name,	String phoneNum, String major, int level, String email){
		this.name=name;
		this.phoneNum=phoneNum;
		this.major=major;
		this.level=level;
		this.email=email;
	}
	void print() {
		System.out.println("이름    : "+name);
		System.out.println("전화번호 : "+phoneNum);
		System.out.println("전공    : "+major);
		System.out.println("학년    : "+level+"학년");
		System.out.println("email  : "+email);
		System.out.println("생일    : "+birthday);
		System.out.println("주소    : "+address);
	}
	public static void main(String[] args) {
		Member m = new Member("Jamie", "010-5989-1245", "불어",1,"abcd@naver.com", "1900년 0월 0일", "서울시 마포구");
		m.print();
		
		System.out.println();
		Member m2 = new Member("Amy", "010-0525-1630", "라틴어",3,"efgh@naver.com");
		m2.print();
	}
	
	
}
