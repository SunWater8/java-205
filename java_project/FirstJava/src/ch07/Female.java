package ch07;

class Female extends Person{
	int age;
	Female(){}
	Female(String name, int personNum) {
		super(name, personNum);
	}
	void watching() {
		System.out.println("그녀는 영화를 보고 있다.");
	}
	void greeting() {
		System.out.println("안녕하세요. 저는 허신숙 입니다.");
	}
}
	