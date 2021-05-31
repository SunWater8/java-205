package ch08;

public class CalculatorMain {

	public static void main(String[] args) {
		Calculator cal = new CalculatorClass();
		System.out.println(cal.add(2, 3));
		System.out.println(cal.substract(2, 3));
		System.out.println(cal.multiply(2, 3));
		System.out.println(cal.divide(6, 3));
		
	}

}
