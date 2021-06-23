package temp;

import java.util.Scanner;

public class AppMain {
	
	static MemberManager memManager = new MemberManager(MemberDao.getInstance());
	static SaleManager saleManager = new SaleManager(SaleDao.getInstance());
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		AdminManager aManager = new AdminManager();
		try {
			// 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("로그인 화면");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 관리자모드");
			int num = Integer.parseInt(sc.nextLine().trim());
			switch (num) {
			case 1:
				memManager.memAdd();
				break;
			case 2:			
				memManager.chkLogin();
				break;
			case 3 :
				//관리자 모드로 들어갈 때 메소드
				if(num == 3) {
					aManager.showAdminMenu();
					
				}
			default :
				System.out.println("잘못 눌렀습니다.");
			}

			while (true) {
				System.out.println("1. 주문하기");
				System.out.println("2. 포인트확인");
				System.out.println("3. 내 정보 확인");
				num = Integer.parseInt(sc.nextLine().trim());

				switch (num) {
				case 1:
					saleManager.order(memManager.currentId); //주문하기 -> 예상결제금액, 예상 적립 포인트 보여주기
					break;
				case 2:
					memManager.memPoint();
					break;
				case 3:
					memManager.myInfo();
					System.out.println("1. 정보수정");
					System.out.println("2. 회원탈퇴");
					num = Integer.parseInt(sc.nextLine().trim());
					switch (num) {
					case 1:
						memManager.memEdit();
						break;
					case 2:
						memManager.memDel();
						return;				
					}
				}
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}