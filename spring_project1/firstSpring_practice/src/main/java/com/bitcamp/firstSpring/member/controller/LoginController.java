package com.bitcamp.firstSpring.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.firstSpring.member.domain.LoginInfo;
import com.bitcamp.firstSpring.member.domain.LoginRequest;

//import com.bitcamp.firstSpring.member.domain.LoginInfo;
//import com.bitcamp.firstSpring.member.domain.LoginRequest;

/*
 //버전 1.심플한 버전
 // index.jsp 에서 경로를 /member/loginform으로 해 주어야 함.
 // loginForm.jsp 에서 action 사용
@Controller
public class LoginController{
	
	@RequestMapping("/member/loginform")
	public String getLoginForm() {
		return "/member/loginForm";
}
*/


 /*
 //버전 2-1. get/post 방식 구현 버전 - value 속성 사용
// index.jsp 에서 경로를 /member/login으로 해 주어야 함.
//loginForm.jsp 에서 action 사용 안함
@Controller
@RequestMapping("/member/login") // 브라우저에서 사용하는 URL  http://localhost:8080/mvc/member/login
public class LoginController {
	
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String getLoginForm() {
		return "/member/loginForm";
	}
	
	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public String login() {
		return "/member/login";
	}
}
*/	
/*
 //버전 2-2. get/post 방식 구현 버전 - value 빼기
@Controller
@RequestMapping("/member/login") // 브라우저에서 사용하는 URL  http://localhost:8080/mvc/member/login
//아래 메소드의 기본 경로를 클래스가 미리 맞춰놓음.
public class LoginController {
	//value를 넣는다면 url이 /member/login/member/login 이런 식으로 두번 입력이 됨
	@RequestMapping( method = RequestMethod.GET)
	public String getLoginForm() {
		return "/member/loginForm";
	}
	
	@RequestMapping( method=RequestMethod.POST)
	public String login() {
		return "/member/login";
	}
}
*/ 

/*
//버전 3. 사용자가 아이디와 비밀번호를 입력해서 로그인 하면 그 데이터를 받기
@Controller
@RequestMapping("/member/login") // 브라우저에서 사용하는 URL  http://localhost:8080/mvc/member/login
public class LoginController {	
	
	@RequestMapping(method = RequestMethod.GET)
	public String getLoginForm( @RequestParam("page") int page ) {//사용자의 페이지 요청 받기
		
		System.out.println(page+1); 
		//page가 int 타입이라서 '/login?page=1'이라고 url을 입력하면 (사용자가 1페이지를 요청하면)
		//1과 계산된 결과 값 2가 콘솔에 출력이 됨. - 데이터 타입과 parameter 이름을 일치시켜야 함을 주의하기
		
		return "member/loginForm"; // /WEB-INF/views/member/loginForm.jsp
	}

	@RequestMapping(method = RequestMethod.POST)
	public String login(
			
			//parameter 방식으로 받기 - loginForm.jsp 의  name 값을 어노테이션 괄호 안에 넣어주면 됨. 
			@RequestParam("id") String id, 
			@RequestParam("pw") String pw
			) {
		System.out.println(id + " : " + pw);
		 return "member/login"; //   /WEB-INF/views/member/login.jsp
	}
}

*/

/*
//버전4.
@Controller
@RequestMapping("/member/login") // 브라우저에서 사용하는 URL  http://localhost:8080/mvc/member/login
public class LoginController {	
	
	@RequestMapping(method = RequestMethod.GET)
	public String getLoginForm() {
		return "member/loginForm"; // /WEB-INF/views/member/loginForm.jsp
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(
			
			//1. parameter 방식으로 받기 loginForm.jsp 의  name 값을 어노테이션 괄호 안에 넣어주면 됨. 
			@RequestParam("id") String id, 
			@RequestParam("pw") String pw,
			
			//3. 이 login 메소드를 호출 할 때 mvc 내부에서는  HttpServletRequest 도  같이 보내준다. 현재 request 반환.
			HttpServletRequest request
			) {
		
		//2. @RequestPraram으로 받은 사용자 입력 데이터 출력하기
		System.out.println(id + " : " + pw);
		
		//4. 내장객체 request로 값을 변수에 받는다.
		String uid = request.getParameter("id");
		String upw = request.getParameter("pw");
		
		//5. HttpServletRequest로 받은 사용자 입력 데이터 출력하기
		System.out.println(uid + " : " + upw);
		
		return "member/login"; // /WEB-INF/views/member/login.jsp
	}
}
*/
/*
//버전5. Beans 객체로 사용자가 입력한 데이터를 받기
@Controller
@RequestMapping("/member/login") // 브라우저에서 사용하는 URL  http://localhost:8080/mvc/member/login
public class LoginController {	
	
	@RequestMapping(method = RequestMethod.GET)
	public String getLoginForm() {
		return "member/loginForm"; // /WEB-INF/views/member/loginForm.jsp
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(
			
			@RequestParam("id") String id, 
			@RequestParam("pw") String pw,
			
			HttpServletRequest request,
			
			//1. LoginRequest 클래스의 기본 생성자를 이용해 아이디와 비밀번호를 받도록 하기
			LoginRequest loginRequest 
			) {
		
		// 사용자의 파라미터 데이터를 받는 방법
		// 방법1. HttpServletRequest 이용		  - request 처리가 많을 때
		// 방법2. @RequestParam("param name")  - parameter 적을 때
		// 방법3. 커멘드 객체(Beans) 이용 			  - parameter 많을 때
		
		System.out.println(id + " : " + pw);
 
		String uid = request.getParameter("id");
		String upw = request.getParameter("pw");
		
		System.out.println(uid + " : " + upw);
		
		//2. LoginRequest 이용해서 결과물 출력하기
		System.out.println(loginRequest);
		
		return "member/login"; // /WEB-INF/views/member/login.jsp
	}
}
*/

//버전6. page 설정, 경로에 대한 설명, 데이터 공유 (view 페이지로 데이터를 전송하는 방법)-Model 객체 사용
@Controller
@RequestMapping("/member/login") // 브라우저에서 사용하는 URL  (contextpath 뒤의 경로를 정해줌) http://localhost:8080/mvc/member/login
public class LoginController {	//사용자가 url에 http://localhost:8080/mvc/member/login이렇게 요청하면 여기 있는 메소드를 실행하라는 뜻. 내가 실행하도록 하는 것이 아니라 mvc 내부에서 실행하도록 시스템이 되어 있다.
	
	@RequestMapping(method = RequestMethod.GET)
	public String getLoginForm( 
			
			//1. @RequestParam 의 괄호에 대한 설명 : 
			//value는 파라미터 이름을 지정, 
			//required는 false라고 지정할 때 값이 들어오지 않으면 오류를 발생시킨다. true 이거나 생략하면?, 
			//defaultValue는 파라미터 값이 없으면 기본 값으로 설정할 것을 의미한다. (문자열로 되어 있음)
			@RequestParam(value = "page",/* required=false,*/ defaultValue = "1") String page 
			//String page : 값을 받아 올 때 데이터 타입을 String으로 하고 나중에 타입을 바꾸든지 하면 된다. 
			
			) {
		
		System.out.println(page);
		return "member/loginForm"; // 응답으로 만들어 주는 jsp 경로.   /WEB-INF/views/member/loginForm.jsp
									//사용자가 login 을 요청을 하면 이 jsp 경로로 응답을 해준다.
									//이 경로는 controller가 반환하는 view name 이다.
	}

	@RequestMapping(method = RequestMethod.POST)
	public String login(
			
			@RequestParam("id") String id, 
			@RequestParam("pw") String pw,
			
			HttpServletRequest request, 
			
			//5. 이 요청에 대한 이름을 'loginReq' 라고 지정하기  - login.jsp 에서 el 을 쓸 때 loginReq 라고 하면 됨.
			@ModelAttribute("loginReq") LoginRequest loginRequest,
			
			//2. 공유할 수 있는 모델 객체를 같이 보냄. 
			//이 메소드의 반환 타입이 String 이라서 view 만 반환해야 하기 때문에 Model 객체를 이용해서 데이터를 담아 내보내야 한다.
			//ModelAndView 타입으로 반환한다면 Model 객체는 당연히 쓰지 않아도 된다.
			Model model 
			
			) {
		System.out.println(id + " : " + pw);
		
		//3. view에 전달할 데이터 저장 : Model 객체를 이용
		//ModelAndView 에서는 addObject 였음
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		String uid = request.getParameter("id");
		String upw = request.getParameter("pw");
		
		System.out.println(uid + " : " + upw);
		
		//4.
		model.addAttribute("uid", uid);
		model.addAttribute("upw", upw);
		
		//이미 객체를 만들어 공유한 데이터들을 담고 있기 때문에  이 객체를 addAttribute 해서 model 에 넣을 필요는 없다. 
		System.out.println(loginRequest);
		
		//세션의 속성에 loginInfo 등록
		//request.getSession(false).setAttribute("loginInfo", new LoginInfo());
		
		return "member/login"; // /WEB-INF/views/member/login.jsp
	}

}
