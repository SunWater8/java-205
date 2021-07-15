package firstweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//02-1 xml에 따로 등록하지 않고 tomcat 내부에서 제공하는 서블릿을 사용하기
//run as 누르면 클래스가 바뀌었기 때문에 서버를 재시작 해야 한다.
@WebServlet("/now2")
public class NowServlet extends HttpServlet {

	//01-1.doget과 dopost 메소드 오버라이딩 하기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//01-2. post 방식에서는 출력으로 처리하기
		System.out.println("Get 방식으로 요청");
		
		//01-5. content type을 html로 지정 (fistsp.jsp의 meta 참고)
		resp.setContentType("text/html; charset=utf-8");
		
		//01-3. 문자열로 쓰여지게 되면 출력하는 게 아니라 response 가 가져가게 된다. 
		PrintWriter writer = resp.getWriter();
		//01-4. 자바스크립트처럼 html을 만들어 준다
		writer.println("<html>");
		writer.println("<head><title>NowServlet</title></head>");
		writer.println("<body>");
		writer.println("<h1>"+new Date()+"</h1>");
		writer.println("</body>");
		writer.println("</html>");
		
		//01-6.  writer 객체는 IO이기 때문에 닫는 과정이 필요
		writer.close();
	}
	//01-1 오버라이딩
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post 방식으로 요청");
	}
	
	

}
