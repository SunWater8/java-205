package ch03;

import java.util.Scanner;

public class Calculator {
	static int add(int a, int  b) {
		return a+b;
	}
	static int sub(int a, int  b) {
		return a-b;
	}
	static int mul(int a, int  b) {
		return a*b;
	}
	static int div(int a, int  b) {
		return a/b;
	}
	
	
	static double circleRound(double a) {
		double pi = Math.PI;
		return 2*pi*a;
	}
	
	static double circleArea(double a) {
		double pi = Math.PI;
		return pi*a*a;
	}
	
	static void result(int a, int b) {
		System.out.println("두 수를 더하면 "+add(a,b)+"입니다.");
		System.out.println("두 수를 빼면 "+sub(a,b)+"입니다.");
		System.out.println("두 수를 곱하면 "+mul(a,b)+"입니다.");
		System.out.println("두 수를 나누면 "+div(a,b)+"입니다.");
	}
	static void circleResult(double a) {
		System.out.println("반지름이 "+a+"인 원의 둘레는"+circleRound(a)+"입니다.");
		System.out.println("반지름이 "+a+"인 원의 넓이는"+circleArea(a)+"입니다.");
	}
	
	static int getIntNum() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		int num = Integer.parseInt(input);
		return num;
	}
	static double getDoubleNum() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		Double num = Double.parseDouble(input);
		return num;
	}
	public static void main(String[] args) {
		System.out.println("사칙연산 하기");
		System.out.print("첫 번째 정수 입력 : ");
		int a = getIntNum();
		System.out.print("두 번째 정수 입력 : ");
		int b = getIntNum();
		result(a,b);
		
		System.out.println("circle");
		System.out.print("반지름 입력 : ");
		double c = getDoubleNum();
		
		circleResult(a);
		
	
		
		
		
	}
	
	
}
