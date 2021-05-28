package ex;

public class FrieldMain {
	public static void main(String[] args) {
		
		Friend f1 = new Friend("손흥민");
		Friend f2 = new Friend("이강인");
		
		System.out.println(f1);//f1의 toString메소드를 호출.
		System.out.println(f2);
	}
}
class Friend{
	String myName;
	Friend(String name){
		myName=name;
	}
	
	public String toString() {
		return "나의 이름은 " + myName+"입니다."; 
	}
}