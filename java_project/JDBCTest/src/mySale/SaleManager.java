package mySale;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import groupStarbucks.MemberDao;

public class SaleManager {
	
	
	private Connection conn = null;
	private SaleDao dao;
	private String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "hr";
	private String pw = "tiger";
	Scanner sc = new Scanner(System.in);
	
	
	void selectSales() {
		
		try {
			conn = DriverManager.getConnection(jdbcUrl, user, pw);
			System.out.println("날짜별 매출 확인하기");
			String inputDate = sc.nextLine();
			dao.selectSales(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
