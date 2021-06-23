package mySale;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaleDao {

	public void selectSales(Connection conn, Sale sale) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "tiger"; 
		
		try {
			conn = DriverManager.getConnection(jdbcUrl, user, pw);
			
			System.out.println("");
			String sqlSelect = "select sum(price) from sale where saledate like ? ";
			pstmt = conn.prepareStatement(sqlSelect);
			
			pstmt.setString(1, sale.getSaledate()+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int sum = rs.getInt("sum(price)");
				System.out.println(sum);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	// 회원 DB에서 point를 read하기
	
	
	String readPoint = "select point from member where id = ?";
	pstmt= conn.prepareStatement(readPoint);
	
	pstmt.setString(1, memId);
	rs = pstmt.executeQuery();
	
	int currPoint = 0;
	while(rs.next()) {
		currPoint = rs.getInt("point");
	}
	
	
	System.out.println("현재 사용가능한 포인트: " + currPoint);
	System.out.println("포인트를 사용하시겠습니까? 1. 예 2. 아니오");
	System.out.println("(포인트를 사용할시 현재 결제하시는 상품의 포인트는 적립이 되지 않습니다.)");

}
