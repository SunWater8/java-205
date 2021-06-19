package myJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyjdbcTest2 {
	public static void main(String[] args) {
		//1. 드라이버 로드
		//2. DB 연결
		//3. sql 작성
		//4. close
		Connection conn= null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String pw = "tiger";
			
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스 연결 성공");
			
			//사원번호, 사원이름, 직급, 급여, 부서이름, 부서위치
			stmt = conn.createStatement();
			String sqlQuery= "select e.empno, e.ename, e.job, e.sal, d.dname, d.loc from emp e, dept d where e.deptno=d.deptno";
			rs = stmt.executeQuery(sqlQuery);
								  
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+
								   rs.getString(2)+"\t"+
								   rs.getString(3)+"\t"+
								   rs.getInt(4)+"\t"+
								   rs.getString(5)+"\t"+
								   rs.getString(6)+"\t"
				);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(conn != null) {
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
