package myJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MyjdbcTestDML1 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loading is completed");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String pw = "tiger";
			
			conn = DriverManager.getConnection(url,user,pw);
			System.out.println("Connection with Driver is completed");
			
			conn.setAutoCommit(false);
			System.out.println("\n부서 정보 입력을 시작합니다.");
			System.out.println("부서 이름을 입력해 주세요");
			Scanner sc = new Scanner(System.in);
			String dname = sc.nextLine();
			System.out.println("부서 위치를 입력해 주세요");
			String loc = sc.nextLine();

			String sql = "insert into dept01 values(dept01_deptno_seq.nextval, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dname);
			pstmt.setString(2, loc);
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("data inserted completely.");
			}else {
				System.out.println("fail to insert");
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
		}finally {
			
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}

}
