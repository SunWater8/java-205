package memberInfo;

import java.util.Scanner;

public class MemberMain {
	
	public static void main(String[] args) {
		MemberManager manager = new MemberManager(MemberDao.getInstance());
		
		Scanner sc = new Scanner (System.in);
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			

			
			while(true) {
				System.out.println("회원 정보 관리");
				System.out.println("------------------------");
				System.out.println("1. 내 정보 보기");
				System.out.println("2. 내 정보 수정");
				System.out.println("3. 회원 탈퇴");
				System.out.println("4. 메인으로 가기"); // 주문 & 포인트보기 & 회원정보조회 페이지 단계로 넘어가기(이전페이지)
				System.out.println("------------------------");
				System.out.println("원하시는 번호를 입력해 주세요.");
				System.out.println();
		
				int num = Integer.parseInt(sc.nextLine());
				
				switch(num) {
				case 1:
					manager.selectData();
					break;
				case 2:
					manager.editMember();
					break;
				case 3:
					manager.delMember();
					break;
				case 4:
					System.out.println("이전 단계로 돌아갑니다.");
					break;
				}
			}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
