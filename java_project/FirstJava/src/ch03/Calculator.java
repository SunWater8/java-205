package ch03;

import java.util.Scanner;

public class Calculator {
	 long add(int a, int  b) {
		return (long)a+b;
	}
	 long sub(int a, int  b) {
		return (long)a-b;
	}
	 long mul(int a, int  b) {
		return (long)a*b;
	}
	float div(int a, int  b) {
		return (float)a/b;
	}
	
	final float PI = 3.14f;
	
	 float circleRound(float r) {
		return 2*PI*r;
	}
	
	 float circleArea(float r) {
		return PI*r*r;
	}
	
//	 void result(int a, int b) {
//		System.out.println("두 수를 더하면 "+add(a,b)+"입니다.");
//		System.out.println("두 수를 빼면 "+sub(a,b)+"입니다.");
//		System.out.println("두 수를 곱하면 "+mul(a,b)+"입니다.");
//		System.out.println("두 수를 나누면 "+div(a,b)+"입니다.");
//	}
//	 void circleResult(float a) {
//		System.out.println("반지름이 "+a+"인 원의 둘레는"+circleRound(a)+"입니다.");
//		System.out.println("반지름이 "+a+"인 원의 넓이는"+circleArea(a)+"입니다.");
//	}
//	
	
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("사칙연산 하기");
		System.out.print("첫 번째 정수 입력 : ");
		int num1 = scanner.nextInt();
		System.out.print("두 번째 정수 입력 : ");
		int num2 = scanner.nextInt();
		System.out.println();
//		cal.result(num1,num2);
//		System.out.println();
		System.out.println("두 수를 더하기: "+cal.add(num1, num2));
		
		System.out.println();
		System.out.println("circle");
		System.out.print("반지름 입력 : ");
		float r = scanner.nextFloat();
//		cal.circleResult(r);
//		System.out.println();
		
		System.out.println("입력 받은 반지름의 길이 : "+r);
		System.out.println("원의 둘레 : "+cal.circleRound(r));
		System.out.println("원의 넓이"+cal.circleArea(r));
		
		
	
		
		
		
	}
	
	
}
