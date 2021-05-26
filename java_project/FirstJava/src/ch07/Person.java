package ch07;

public class Person {
	private String name;
	private int personNum;
	void greeting(){
		System.out.println("안녕하세요. 저는 홍길동 입니다. ");
	}
	Person(){}
	Person(String name, int personNum){
		this.name=name;
		this.personNum=personNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPersonNum() {
		return personNum;
	}
	public void setPersonNum(int personNum) {
		this.personNum = personNum;
	}
	
}