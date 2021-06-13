package ex.CollectionFramework.TreeSet_0601;
import java.util.*;
public class TreeSet3_ComparablePerson {
	public static void main(String[] args) {
		TreeSet<Person> set = new TreeSet<>();
		set.add(new Person("jamie",20));
		set.add(new Person("may",25));
		set.add(new Person("paul",30));
		
		//나이로 정렬하기
		Iterator<Person> itr = set.iterator();
		while(itr.hasNext()) {
			itr.next().showData();
		}
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
		
		//정렬하는 4가지 방법의 코드
		
		//오름차순으로 정렬1
//		if(this.age>o.age) {
//			return 10; //양수 아무 숫자 return 
//		}else if(this.age<o.age) {
//			return -10; //음수 아무 숫자 return
//		}else {
//			return 0;
//		}
		
		return this.age-o.age; //오름차순으로 정렬2.
//		return o.age - this.age; // 내림차순으로 정렬1
//		return this.age-o.age*-1;//내림차순으로 정렬2.
	}
}