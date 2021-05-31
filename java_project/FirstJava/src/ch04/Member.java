package ch04;

import java.util.Calendar;
import java.util.Scanner;

public class Member {

	// 태어난 년도를 입력하면 나이를 반환하는 메소드
	int ageCal(int year) {
		return Calendar.getInstance().get(Calendar.YEAR) - year - 1;// 만나이 계산
	}

	void vaccine (int birthYear) {
		int age = ageCal(birthYear);
		
		boolean check1 = age < 15 || age >= 65;
		boolean check2 = !(age >= 15 && age < 65);
		
		System.out.println(check1);
		System.out.println(check2);
		
		if(check2) {
			System.out.println("무료예방접종이 가능합니다.");
		}else {
			System.out.println("무료접종 대상이 아닙니다.");
		}
	}

	void exam(int birthYear) {
		int age = ageCal(birthYear);

		boolean check1 = birthYear % 2 == 0 && 2021 % 2 == 0 || birthYear % 2 == 1 && 2021 % 2 == 1;
		boolean check2 = birthYear % 2 == 2021 % 2;

		if ((20 <= age) && check2) {
			System.out.println("당신은 올 해 건강검진 대상입니다.");
			if (40 <= age) {
				System.out.println("그리고 암 검사는 무료입니다.");
			}
		} else {
			System.out.println("올 해 건강검진 대상자가 아닙니다.");
		}
	}

	public static void main(String[] args) {
		System.out.println(Calendar.getInstance().get(Calendar.YEAR));
		
		Member m = new Member();

		Scanner scanner = new Scanner(System.in);
		System.out.println("이름을 입력해 주세요 >");
		String name1 = scanner.nextLine();
		System.out.println("태어난 년도를 입력해 주세요 >");
		int birthYear = scanner.nextInt();

		System.out.println(name1 + " 님은 ");
		m.vaccine(birthYear);
		m.exam(birthYear);

	}
}
