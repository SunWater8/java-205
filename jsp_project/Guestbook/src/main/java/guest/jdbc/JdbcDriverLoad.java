package guest.jdbc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class JdbcDriverLoad extends HttpServlet {

	/*
	 * public void init(ServletConfig config) throws ServletException) { jdbcDriver
	 * = jdbcDriver == null? "com.mysql.cj.jdbc.Driver"; Class.forName(jdbcDriver);
	 * System.out.println("mysql Driver load... !!"); }
	 */

	@Override
	public void init(ServletConfig config) throws ServletException {
		String jdbcDriver = config.getInitParameter("jdbcdriver");

		try {
			jdbcDriver = jdbcDriver == null ? "com.mysql.cj.jdbc.Driver" : jdbcDriver;
			Class.forName(jdbcDriver);
			System.out.println("mysql Driver load... !!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}