package ch07;

public class PersonMain {
	public static void main(String[] args) {
//		Person person = new Person();
		Person person2 = new Male("홍길동","890523-1548879","1종");
		Person person3 = new Female("허지숙","010524-4589478","Brown");
//		person.greeting();
		person2.greeting();
		person3.greeting();
		
	}
	
}
