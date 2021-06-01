package ch08;

public class CalculatorMain {

	public static void main(String[] args) {
		Calculator cal = new CalculatorClass();//인터페이스도 하나의 클래스처럼 보고 인스턴스 생성할 수 있다(다형성)
		System.out.println(cal.add(2, 3));
		System.out.println(cal.substract(2, 3));
		System.out.println(cal.multiply(2, 3));
		System.out.println(cal.divide(6, 3));
		
	}

}
