package bestMenu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class SaleBestManager {

	private SaleBestDao dao;
	private Scanner sc;
	
	public SaleBestManager(SaleBestDao dao) {
		this.dao=dao;
		sc=new Scanner(System.in);
	}
	
	//콘솔에 출력하는 메소드
	void saleBestList() {
		Connection conn = null;
		
		String jdbcUral= "jdbc:oracle:thin:@localhost:1521:xe";;
		String user = "hr";
		String pw="tiger";
		
		try {
			conn = DriverManager.getConnection(jdbcUral, user, pw);
			List<Sale> list = dao.getSaleBestList(conn);
			
			System.out.println("판매 상품 인기 순위 리스트");
			System.out.println("-------------------------------------");
			System.out.println("순위 \t상품명 \t\t판매횟수 ");
			System.out.println("-------------------------------------");
			
			int rank =1 ;
			for(Sale sale : list) {
				System.out.printf("%d  \t %s \t %d ",rank++,  sale.getSname(), sale.getCount());
				System.out.println();
			}
			
			System.out.println("-------------------------------------");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
