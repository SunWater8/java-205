package ch02;

public class Person {
	String name;
	String phoneNum = "000-0000-0000";
	String perNum1 = "700000-0000000";
	long perNum2 = 7000000000000L;
	
	void showData() {
		System.out.println("회원의 이름 : "+name);
		System.out.println("회원의 주민번호1 : "+ perNum1);
		System.out.println("회원의 주민번호1 : "+ perNum2);
	}
	
	public static void main(String[] args) {
		Person person = new Person();
		System.out.println("이름 : "+person.name);
		
		System.out.println();
		person.name = "Jamie";
		person.showData();
	}
}
