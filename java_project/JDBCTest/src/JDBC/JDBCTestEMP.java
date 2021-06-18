package JDBC;
import java.sql.*;

public class JDBCTestEMP {

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
			//사원 번호, 사원이름, 직급,  sal, 부서이름, 부서위치 (join)
			
			//(1) statement
			stmt = conn.createStatement();
			//(2) sql 작성
			String sql = "select e.empno, e.ename, e.job, e.sal, d.dname, d.loc from emp e, dept d where e.deptno = d.deptno";
			//(3) resultset 객체로 데이터 받기
			rs = stmt.executeQuery(sql);
			//(4) 출력
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"
									+rs.getString(2)+"\t"
									+rs.getString(3)+"\t"
									+rs.getInt(4)+"\t"
									+rs.getString(5)+"\t"
									+rs.getString(6)+"\t"
									);
			}
			
			//rs.next() -> 다음행의 존재 유무 확인true/false. 
			while(rs.next()) {  //다음 행이 없으면 false가 되므로 while을 빠져나옴.
				int deptno = rs.getInt("deptno"); //다음 행의 deptno 번호를 가져옴.
				System.out.print(deptno+"\t");//tab 띄어쓰기
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
