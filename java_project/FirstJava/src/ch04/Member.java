package ch04;
import java.util.Scanner;

public class Member {
	int age;
	int thisYear = 2021;
	
	void vaccine (int birthYear) {
		age = thisYear-birthYear;
		if(!(15>age && 65<=age) ){
			System.out.println("무료예방접종이 가능합니다.");
		}else {
			System.out.println("무료접종 대상이 아닙니다.");
		}
	}

	void exam(int birthYear) {
		age = thisYear-birthYear;
		if((20<=age) && (age%2==0)) {
			System.out.println("당신은 올 해 건강검진 대상입니다.");
			if(40>=age) {
				System.out.println("그리고 암 검사는 무료입니다.");
			}
		}else {
			System.out.println("올 해 건강검진 대상자가 아닙니다.");
		}
	}
	public static void main(String[] args) {
//		String name = "Jamie";
//		int age = 10;
//		double height = 130.5;
//		boolean hasBook = true;
//		System.out.println("My name is "+name);
//		System.out.println("She is "+age+"years old");
//		System.out.println("Her height is "+height);
//		System.out.println("Having a Java Book : "+ hasBook);

		Member m = new Member();
		
		System.out.println();
		Scanner scanner=new Scanner(System.in);
		System.out.println("이름을 입력해 주세요 >");
		String name1 = scanner.nextLine();
		System.out.println("태어난 년도를 입력해 주세요 >");
		int birthYear = scanner.nextInt();
		
		System.out.println(name1+" 님은 ");
		m.vaccine(birthYear);
		m.exam(birthYear);
		
	}
}
