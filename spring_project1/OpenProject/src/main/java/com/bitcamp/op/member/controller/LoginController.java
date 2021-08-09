  
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
	
	@Autowired
	private LoginService loginService;

	@RequestMapping(method = RequestMethod.GET)
	public String loginForm(
			@RequestHeader(value="referer", required = false) String redirectUri,
			Model model
			) {
		model.addAttribute("redirectUri", redirectUri);
		return "member/loginForm";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String login(
			@RequestParam("memberid") String memberid,
			@RequestParam("password") String password,
			@RequestParam(value="redirectUri", required = false) String redirectUri,
			@RequestParam(value="reid", required = false) String reid, //required : null값이 들어와도 상관 없다.
			HttpSession session, //로그인 정보에 대한 session. request로 받아도 됨.
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