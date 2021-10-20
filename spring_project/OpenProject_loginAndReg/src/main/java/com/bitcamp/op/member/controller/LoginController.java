  
package com.bitcamp.op.member.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.member.service.LoginService;

@Controller
@RequestMapping("/member/login") //get방식일 때는 view가 보여지도록 하고, post 방식일 때는 데이터를 받아서 처리하는 뷰를 보여지도록 구분하기 위해서 같은 경로를 통해 들어오게 했다.
public class LoginController {
	//순서2. service 클래스 주입받기
	@Autowired
	private LoginService loginService;

	//순서1. get 방식의 메소드 만들기
	@RequestMapping(method = RequestMethod.GET)
	public String loginForm(
			@RequestHeader(value="referer", required = false) String redirectUri,
			Model model
			) {
		model.addAttribute("redirectUri", redirectUri);
		return "member/loginForm";
	}
	//순서3. post방식 메소드 만들기
	@RequestMapping(method = RequestMethod.POST)
	public String login(
			//사용자가 입력한 id, pw 요청 받기 - 사용자 요청을 처리하는 방식 3가지(RequestParam, HttpServletRequest, command객체)
			
			//memberid, password, reid는 따로 모아서 command 객체로 만들어 사용할 수도 있다.
			@RequestParam("memberid") String memberid,
			@RequestParam("password") String password,
			@RequestParam(value="redirectUri", required = false) String redirectUri, //로그인 성공 후 되돌아갈 경로(로그인 이전에 작업하던 화면). 로그인이 실패라면 밑에 설정한 변수view의 기본값인 login view 가 보여짐.경로가 없을 수도 있기 때문에 required는 false이다.
			@RequestParam(value="reid", required = false) String reid, //required : null값이 들어와도 상관 없다. 체크박스에 체크 안할 수도 있기 때문에 required를 false로 하기.
			HttpSession session, //로그인 정보에 대한 session. request로 getSession 이렇게 받아도 됨.
			HttpServletResponse response, //쿠키 받기위한 response(쿠키 보낼 때 필요)
			Model model
			) {
		
		//사용자가 입력한 id, pw 서비스(서비스 클래스)에 전달해서 db갔다오도록 하여 작업의 짐을 덜어서 로그인 처리(서비스로 일 미루기)//;
		boolean loginChk = loginService.login(memberid, password, reid, session, response);
		model.addAttribute("loginChk", loginChk);//model 에 로그인 처리 결과를 보내주기.

		String view = "member/login";
		
		if(redirectUri != null && loginChk) {
			//로그인이 되면 redirect 뷰가 보여지도록 하기
			view = "redirect : "+redirectUri;
		}
		return view;
		
	}
	
	
}