package jdbc.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class Loader extends HttpServlet{

	//톰캣 컨테이너가 실행할 수 있도록 만들기
	@Override
	public void init() throws ServletException {
		//데이터 베이스 로드 하기
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //try catch 하기
			System.out.println("드라이버 로드 성공!");
		} catch (ClassNotFoundException e) { //클래스를 찾지 못할 경우
			System.out.println("드라이버 로드 실패!");
		}
	}

	
}
