package jdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JdbcUtil {
	//Connection
	public static void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close(); //try catch 발생
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//Statement, PreparedStatement  
	// 이 둘은 상속 관계이기 때문에 PreparedStatement 를 닫는 메소드를 따로 만들 필요가 없다.
	public static void close(Statement stmt) {
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//ResultSet
	public static void close(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
