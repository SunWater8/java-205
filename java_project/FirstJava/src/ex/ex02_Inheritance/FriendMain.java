//java_10_객체지향_상속_65p
package ex;

public class FriendMain {
	public static void main(String[] args) {
		
		Friend f1 = new Friend("손흥민");
		Friend f2 = new Friend("이강인");
		Friend f3 = new Friend("손흥민");
		
		System.out.println(f1);//f1의 toString메소드를 호출.
		System.out.println(f2);
		System.out.println(f3);
		
		System.out.println(f1 == f3); //객체 주소가 다르므로 같지 않다는 false가 나온다.
		System.out.println(f1.equals(f3));//equals는 참조 값을 비교 한다.
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
	public boolean equals(Object o) {
		
		boolean result = false;
		
		if(o != null && o instanceof Friend) {
			Friend f = (Friend)o;
			if(myName.equals(f.myName)) {
				result = true;
			}
		}
		return result;
	}
}