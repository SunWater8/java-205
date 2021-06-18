
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
			
			//3. sql 처리
			//사용자에게 정보를 받아 데이터를 수정
			//10 dev seoul ==> 공백을 포함한 문자열을 받아 업데이트 하기
			
			System.out.println("\n부서 데이터의 수정을 시작합니다.");
			System.out.println("10 dev seoul 형식으로 데이터를 입력해 주세요.");
			String input = sc.nextLine();
			
			//String타입의 배열 만들기
			String[] inputs = input.split(" ");
			
//			for(String str : inputs) {    -- 업데이트 처리하는 방식 출력해보기
//				System.out.println(str);
//			}
			
			String sql ="update dept01 set dname=?, loc=? where deptno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inputs[0]);
			pstmt.setString(2, inputs[1]);
			pstmt.setInt(3, Integer.parseInt(inputs[2]));
			
			int result = pstmt.executeUpdate();
			
			if(result >0) {
				System.out.println("수정되었습니다.");
			}else {
				System.out.println("찾으시는 부서가 존재하지 않습니다.");
			}
			
			
		} catch (ClassNotFoundException e) { //위의 주소 문장에서 내가 잘못 입력했을 경우 오류가 발생할 수 있다.
			System.out.println("드라이버 클래스를 찾지 못함!!!");
			e.printStackTrace();
		} catch (SQLException e) {
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
