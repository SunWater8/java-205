package ch09;

import java.util.Scanner;

public class Name {
	public static boolean checkName(String name) {
		boolean result = true;
		for(int i=0;i<name.length();i++) {
			char c = name.charAt(i);
			if(!(c>='a'&&c<='z' || c>='A'&&c<='z')) {
				result=false;
				break;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.print("영어 이름을 입력하세요 >");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		if(input != null && !input.trim().isEmpty()
				) {
			if(checkName(input)) {
				System.out.println("입력하신 이름은 : "+input);
			}else {
				System.out.println("이름을 표현할 수 없는 문자가 포함되어 있습니다.");
			}
		}else {
			System.out.println("공백문자열이 입력되었습니다.");
		}
	}

}

