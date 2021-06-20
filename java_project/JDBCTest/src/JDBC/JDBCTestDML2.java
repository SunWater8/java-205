
//update 기능 살펴보기
package JDBC;
import java.sql.*;
import java.util.Scanner;

public class JDBCTestDML2 {

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
			
			conn.setAutoCommit(false);
			//3. sql 처리
			//사용자에게 정보를 받아 데이터를 수정
			//10 dev seoul ==> 공백을 포함한 문자열을 받아 업데이트 하기
			
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
		} catch (ClassNotFoundException e) { //위의 주소 문장에서 내가 잘못 입력했을 경우 오류가 발생할 수 있다.
			System.out.println("드라이버 클래스를 찾지 못함!!!");
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("데이터 베이스 연결 실패!!");
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
