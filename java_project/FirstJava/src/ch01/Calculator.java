package ch01;
public class Calculator{
	
	//Method -> function (재료>처리>반환)
	//반환타입 메소드이름(매개변수들) {처리구문}
	void add(int a, int b) {
		System.out.println(a+b);
	}
	void subtract(int a, int b) {
		System.out.println(a-b);
	}
	void multiply(int a, int b) {
		System.out.println(a*b);
	}
	void divide(int a, int b) {
		System.out.println(a/b);
	}
	
	
	public static void main(String[] args) {
		Calculator cal = new Calculator();//메모리에 메소드 코드를 저장하는 과정. //참조변수 cal에는 주소 값만 저장되어 있음..(윈도우의 바로가기 아이콘과 비슷) 인스턴스가 생성되자마자 해당되는 메소드는 메모리에 올라옴.
		cal.add(10, 20);
		cal.subtract(20, 10);
		cal.divide(10, 3); //데이터타입에 따라서 변수가 저장하는 스타일이다르기 때문에 int는 소수점을 저장할 공간이 없어서 소수점 이하가 짤려서 값이 나오게 된다.
		cal.multiply(2, 3);
	}	
}

