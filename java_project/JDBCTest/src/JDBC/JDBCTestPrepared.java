package JDBC;
import java.sql.*;

public class JDBCTestPrepared {

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
			stmt = conn.createStatement();
			
			int dno = 10;
			String otype = "deptno";
			
			String sqlSelect = 
					"select * from dept where deptno = "+dno+" order by " + otype;
					
			rs = stmt.executeQuery(sqlSelect);
			
			//rs.next() -> 다음행의 존재 유무 확인true/false. 
			while(rs.next()) {  //다음 행이 없으면 false가 되므로 while을 빠져나옴.
				int deptno = rs.getInt("deptno"); //다음 행의 deptno 번호를 가져옴.
				System.out.print(deptno+"\t");//tab 띄어쓰기
				String dname = rs.getString("dname");
				System.out.print(dname+"\t");
				String loc = rs.getString("loc");
				System.out.print(loc+"\t");
			}
			
			///////////////////////////////////////
			//preparedStatement 살펴보기 : 기존의 statement 를 개선
			//preparedStatement -> sql 먼저 등록 -> 매개변수처럼 ?물음표를 이용해서 나중에 변수를 바인딩해준다. (래핑)
			System.out.println("\n======================================");
			System.out.println("PreparedStatement 사용");
			
			String sqlSelect2 = "select * from dept where deptno = ? ";
			pstmt = conn.prepareStatement(sqlSelect2);
			//물음표 변수에 데이터 바인딩(연결)
			pstmt.setInt(1, 10);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int deptno = rs.getInt("deptno"); 
				System.out.print(deptno+"\t");
				String dname = rs.getString("dname");
				System.out.print(dname+"\t");
				String loc = rs.getString("loc");
				System.out.print(loc+"\t");
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
