package ch05;

public class Member {
	private String name;
	private String phoneNum;
	private String major;
	private int level; // grade
	private String email;
	private String birthday; // 2020-10-10이런 형태로 저장하고 싶을 때.
	private String address;
	
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
	
	Member(String name,	String phoneNum, String major){
		this(name, phoneNum, major, 0, null,null,null);
	}
	Member(){
		this.phoneNum = "000-0000-0000";
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	void showInfo() {
		System.out.println("이름    : "+name);
		System.out.println("전화번호 : "+phoneNum);
		System.out.println("전공    : "+major);
		System.out.println("학년    : "+level+"학년");
		System.out.println("email  : "+email);
		
		if(this.birthday == null) {
			System.out.println("생일 : 입력된 데이터가 없습니다.");
		}else {
			System.out.println("생일 : "+birthday);
		}
		
		if(this.address == null) {
			System.out.println("주소 : 입력된 데이터가 없습니다.");
		}else {
			System.out.println("주소 : "+address);
		}
	}
	public static void main(String[] args) {
		Member m = new Member("Jamie", "010-5989-1245", "불어",1,"abcd@naver.com", "1900년 0월 0일", "서울시 마포구");
		m.showInfo();
		
		System.out.println();
		Member m2 = new Member("Amy", "010-0525-1630", "라틴어",3,"efgh@naver.com");
		m2.showInfo();
	}
	
	
}
