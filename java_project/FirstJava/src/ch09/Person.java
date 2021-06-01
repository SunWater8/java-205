package ch09;

public class Person {
	String name;
	String personNumber;
	
	Person(String name, String personNumber){
		this.name=name;
		this.personNumber=personNumber;
	}
	
	
	public boolean equals (Object obj) {
		boolean result = false;
		if(obj!=null && obj instanceof Person) {
			Person p = (Person)obj;
			result = this.personNumber.equals(p.personNumber);
		}
			
		return result;
	}
	public static void main(String[] args) {
		Person person = new Person("김명호", "123456-7890123");
		Person person2 = new Person("강지호", "123456-7890123");
		Person person3 = new Person("이지수", "456789-0123456");
		
		System.out.println(person.equals(person2));
		System.out.println(person2.equals(person3));
	}

}
