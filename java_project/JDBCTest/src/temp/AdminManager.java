package temp;

import java.util.Scanner;

import memberInfo.MemberDao;
import memberInfo.MemberManager;

public class AdminManager {
	
	public void showAdminMenu() {

		Scanner sc = new Scanner(System.in);
		MemberManager mManager = new MemberManager(MemberDao.getInstance());
		SaleManager sManager = new SaleManager(SaleDao.getInstance());
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
			while(true) {
			System.out.println("관리자 모드 메뉴");
			System.out.println("--------------------");
			System.out.println("1. 고객 정보 리스트 조회");
			System.out.println("2. 판매 정보 조회");
			System.out.println("3. 판매하는 상품 조회");
			System.out.println("--------------------");
			System.out.println("번호를 입력해 주세요.");
			System.out.println();
			
			int input = Integer.parseInt(sc.nextLine());
			switch(input) {
			case 1:
				mManager.memList();
				break;
			case 2: 
				sManager.saleList();
				break;
				
			case 3:
				
				break;
			}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}
}

