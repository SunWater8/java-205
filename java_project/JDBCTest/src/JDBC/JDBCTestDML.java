package JDBC;
import java.sql.*;
import java.util.Scanner;

public class JDBCTestDML {

	public static void main(String[] args) {
		//finally 에서 처리되기 위해 이 곳에 변수를 선언한다.
		
		//연결 객체 : 연결 정보를 가진다.
		Connection conn = null;
		//sql을 실행할 메소드 제공
		Statement stmt = null;
		//executeQuery() 반환타입 -> select의 결과(테이블, 표)를 담는 객체라고 보면 된다.
		ResultSet rs= null;
		//statement -> PreparedStatement : 성능 개선.
		PreparedStatement pstmt = null;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			//1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공!!");
			
			//2. 연결
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String pw = "tiger";
			
			conn = DriverManager.getConnection(jdbcUrl, user, pw);
			System.out.println("데이터 베이스 연결 성공!!");
			
			//트렌젝션 설정
			conn.setAutoCommit(false);
			
			
			//3. sql 처리
			//사용자에게 정보를 받아 부서 데이터를 입력하는 프로그램을 만들어보자
			System.out.println("\n부서 정보 입력을 시작합니다.");
			System.out.println("부서 이름을 입력해 주세요.");
			String dname = sc.nextLine();
			System.out.println("부서 위치를 입력해 주세요.");
			String loc = sc.nextLine();

			String sql = "insert into dept values (DEPT01_DEPTNO_SEQ.nextVal, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
			
			int result = pstmt.executeUpdate(); //executeUpdate() 메소드는 반영된 로우의 개수를 반환한다.
			
			if(result >0) { 
				System.out.println("입력되었습니다.");
			}else {
				 System.out.println("입력 실패!!!");
			}
			
			//트랜젝션의 완료(성공)
			conn.commit();
			
		} catch (ClassNotFoundException e) { //위의 주소 문장에서 내가 잘못 입력했을 경우 오류가 발생할 수 있다.
			System.out.println("드라이버 클래스를 찾지 못함!!!");
			e.printStackTrace();
		} catch (SQLException e) {
//			System.out.println("데이터 베이스 연결 실패!!");
			
			//트랜젝션을 rollback하게 될 때 예외
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		
		}finally {
						
			//4. close
			
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn !=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
		
	}

}
