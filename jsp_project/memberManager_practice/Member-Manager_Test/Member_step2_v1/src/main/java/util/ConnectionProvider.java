package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	public static Connection getConnection() throws SQLException { //연결이 안되면 받는 쪽에서 예외처리 하게 하기.
		String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone-UTC";
		String user = "bit";
		String pw = "bit";
		
		return DriverManager.getConnection(jdbcUrl, user, pw); //예외처리 해야함.
	}
}
