package myJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MyjdbcTestDML2 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loading is completed.");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String pw = "tiger";
			
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("connction with db is completed.");
			
			conn.setAutoCommit(false);
			Scanner sc = new Scanner(System.in);
			System.out.println("부서 정보의 삭제를 시작합니다.");
			System.out.println("부서번호를 입력해주세요.");
//			int deptno = sc.nextInt();
			String deptno = sc.nextLine();
			
			String sql = " delete from dept01 where deptno=?";
			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1,deptno);
			pstmt.setInt(1,Integer.parseInt(deptno));
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("delete data completly");
			}else {
				System.out.println("failure of deleting");
			}
			
			conn.commit();
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		
	}
}
