  
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
@RequestMapping("/member/login")
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
			@RequestParam(value="redirectUri", required = false) String redirectUri,
			@RequestParam(value="reid", required = false) String reid, //required : null값이 들어와도 상관 없다. 체크박스에 체크 안할 수도 있기 때문에 required를 false로 하기.
			HttpSession session, //로그인 정보에 대한 session. request로 getSession 이렇게 받아도 됨.
			HttpServletResponse response, //쿠키 받기위한 response(쿠키 보낼 때 필요)
			Model model
			) {
		
		//사용자가 입력한 id, pw 서비스에 전달해서 로그인 처리
		boolean loginChk = loginService.login(memberid, password, reid, session, response);
		model.addAttribute("loginChk", loginChk);

		String view = "name/login";
		
		if(redirectUri != null && loginChk) {
			//로그인이 되면 redirect 뷰가 보여지도록 하기
			view = "redirect : "+redirectUri;
		}
		return "member/login";
		
	}
	
	
}