package jdbc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class DriverLoader extends HttpServlet {

	@Override
	//﻿ServletConfig 클래스 : 파라미터를 읽어 올 수 있는 기능을 제공해 준다.
	//작동 원리 - 톰캣 컨테이너가 DriverLoader를 실행할 때 파라미터에 있는 값을 ServletConfig 객체에 넣어서 매개변수로 전달을 해준다.
	public void init(ServletConfig config) throws ServletException {
		//web.xml에서 파라미터 이름이 driver로 된 20,21행을 읽어서 해당 parameter를 가져와 params 변수에 저장.
		String params = config.getInitParameter("driver");
		
		try {
			if (params != null) {
				//params 가 null 이 아니면 그 경로를 로드하도록 한다.
				Class.forName(params);
				System.out.println("드라이버 로드 성공");
			} else {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("드라이버 로드 성공");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		}

	}

}
