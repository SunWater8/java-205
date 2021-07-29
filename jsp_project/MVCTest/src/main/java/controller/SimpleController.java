package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SimpleController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doprocess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doprocess(request, response);
	}
	
	protected void doprocess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 요청이 어떤 것인지 부터 파악하기
		String type = request.getParameter("type");
		
		Object resultObj = null;
		String viewPage = "/WEB-INF/views/default.jsp";
		
		//2. 모델 선택하기
		if(type == null || type.equals("greeting")) {
			// 출력할 메시지 입력하기
			resultObj = "안녕하세요";
			//뷰 지정하기
			viewPage = "/WEB-INF/views/greeting.jsp";
			
		}else if(type.equals("date")) {
			resultObj = new Date();
			viewPage = "/WEB-INF/views/date.jsp";
		}else {
			resultObj = "Invalid Type Request";
		}
		
		//3. 공유하기
		request.setAttribute("result", resultObj);
		
		//4. view 지정하기
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
	
}
