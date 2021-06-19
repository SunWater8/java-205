package myJdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class myJdbcTest1 {

	public static void main(String[] args) {
		//2-2. 연결 정보를 갖고 있는 연결 객체 만들기(class import)
		Connection conn = null;
		//3-1. sql 처리를 위한 메소드를 제공하는 객체 생성 (class import)
		Statement stmt = null;
		//3-3. sql의 반환을 담는 객체 생성 (class import)
		ResultSet rs = null;
		
		try {
			//1-1. 드라이버로드(예외-ClassNotFoundException:메소드 괄호에 입력한 정보가 잘못 입력 되었을 경우발생)
			Class.forName("oracle.jdbc.driver.OracleDriver"); //이 드라이버는 외워야 하는 건지 궁금
			System.out.println("드리이버 로드 성공!!");
			
			//2-1. 연결
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String pw = "tiger";
			
			//2-3. 드라이버에 연결할 정보 (예외-SQLException) (class import)
			conn = DriverManager.getConnection(jdbcUrl,user,pw);//DriverManager는 클래스 이름인가?yes
			System.out.println("데이터베이스 연결 성공!!");
			
			//3-2. sql 처리. statement 생성 > sql 전송
			stmt = conn.createStatement();
			String sqlSelect = "select * from dept order by dname"; //while 문에는 몇개의 컬럼만 취급하는데 그럼 여기의 *는 잘못 쓰여진게 아닌지? 정렬은 어떻게 오름차순으로 되는건지?
			//3-4. 반환할 값을 넣기 (select 명령으로 만들어진 표를 반환)
			rs = stmt.executeQuery(sqlSelect);
			//3-5. 한 행씩 읽어 들인다. next()는 boolean 메소드. 다음이 없을 경우 false를 반환한다. 
			while(rs.next()) {
				int deptno = rs.getInt("DEPTNO");
				System.out.print(deptno+"\t");
				String dname = rs.getString("DNAME");
				System.out.print(dname+"\t");
				String loc = rs.getString("LOC");
				System.out.print(loc+"\t");
				
				System.out.println();
			}
			
			//1-2. 드라이버로드의 예외
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			//2-4. 드라이버 연결의 예외 (class import)
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { 
			//4.close
			if(conn !=null ) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
