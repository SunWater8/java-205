package ch07;

import java.util.Calendar;

public class Person {

	private String name;
	private String personNum;
	
	Calendar today = Calendar.getInstance();	
	int thisYear = today.get(Calendar.YEAR);
	
	int age() {
		if((personNum.charAt(7)=='3')||(personNum.charAt(7)=='4')) {
			String frontTwo = personNum.substring(0,2);
			int numTwo = Integer.parseInt(frontTwo);
			return thisYear-(numTwo+2000);
		}else {
			String frontTwo = personNum.substring(0,2);
			int numTwo = Integer.parseInt(frontTwo);
			return thisYear-(numTwo+1900);
		}
	}

	void greeting(){
		System.out.println("안녕하세요. 저는 "+name+"입니다. "+age()+"살 입니다.");
	}
	Person(){}
	Person(String name, String personNum){
		this.name=name;
		this.personNum=personNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPersonNum() {
		return personNum;
	}
	public void setPersonNum(String personNum) {
		this.personNum = personNum;
	}

}