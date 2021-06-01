package ex.CollectionFramework.TreeSet_0601;
import java.util.*;
public class TreeSet3_ComparablePerson {
	public static void main(String[] args) {
		Person p = new Person("jamie",20);
		p.showData();
		p.compareTo(p);
	}
}

class Person implements Comparable<Person>{
	String name;
	int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void showData() {
		System.out.printf("%s, %d \n",name, age);
	}

	@Override
	public int compareTo(Person o) {
		if(this.age>o.age) {
			return 10; //양수 아무 숫자 return 
		}else if(this.age<o.age) {
			return -10; //음수 아무 숫자 return
		}else {
			return 0;
		}
		
		
//		return this.age-o.age;
		
//		return this.age-o.age*-1;//반대 정렬 하고 싶을 때.
	}
}