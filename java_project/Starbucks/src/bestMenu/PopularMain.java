package bestMenu;

import java.util.Scanner;

public class PopularMain {

	public static void main(String[] args) {
		SaleBestManager manager = new SaleBestManager(SaleBestDao.getInstance());
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 메소드를 호출합니다.
			manager.saleBestList();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
