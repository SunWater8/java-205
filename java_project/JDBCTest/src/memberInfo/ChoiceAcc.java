package memberInfo;

import java.util.Scanner;

public class ChoiceAcc {

	public void showAccount() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("반갑습니다.");
		System.out.println("로그인을 시작합니다.");
		System.out.println("해당하는 번호를 선택해 주세요.");
		System.out.println("---------------------------");
		System.out.println("1. 회원 로그인");
		System.out.println("2. 비회원 (회원가입)");
		System.out.println("3. 관리자 모드");
		System.out.println("---------------------------");
		
		int num = sc.nextInt();
		switch(num) {
		case 1:
			System.out.println("아이디와 비밀번호를 입력해 주세요.");
			System.out.print("아이디 : ");
			String inputId = sc.nextLine();
			System.out.print("아이디 : ");
			String inputPw = sc.nextLine();
			
//			if(inputId == )
			
			
		}
		
	}

}
