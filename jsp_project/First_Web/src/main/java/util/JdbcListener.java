package util;

import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class JdbcListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		System.out.println("Listener 진입!");
		
		try {// class notFound Exception 예외 관련
			ServletContext context = sce.getServletContext();
			String drivers = context.getInitParameter("jdbcdriver");

			StringTokenizer tokenizer = new StringTokenizer(drivers, ",");
			// 데이터 가져오기
			while (tokenizer.hasMoreTokens()) {
				String jdbcDriver = tokenizer.nextToken();
				// 드라이버 로드
				Class.forName(jdbcDriver);
				System.out.println("드라이버 로드 성공!");
				//서블릿보다 리스너가 먼저 실행. 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
