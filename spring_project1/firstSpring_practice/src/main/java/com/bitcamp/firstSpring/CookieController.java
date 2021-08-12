package com.bitcamp.firstSpring;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
	
	//쿠키 생성해주는 요청 처리
	@RequestMapping(value="/cookie/make")
	public String makeCookie(HttpServletResponse response) {
	
		Cookie c = new Cookie("username", "KING");
		
		//사용자 쪽으로 만든 쿠키를 보내줌.
		response.addCookie(c);
		
		//특정 서비스에 특정 메소드를 이용해서 쿠키를 보내줄 수도 있다.
		//Service.process(response); // <- 임의로 만든 문장
		
		return "cookie/make";
	}
	
	
	@RequestMapping("/cookie/view")
	public String viewCookie(
			//쿠키설정1
			//name을 String으로 받음?
			//@CookieValue("username") String userName,
			
			//쿠키설정2
			//required 가 true 라면 필수, false면 필수 아님.
			//@CookieValue(value = "username", required = false) String userName,
			
			//쿠키설정3
			//쿠키 username 이 원래 없다면 defaultvalue를 scott 이라고 기본설정을 한다.
			@CookieValue(value = "usernames", defaultValue = "SCOTT") String userName,
			
			Model model
			) {
		model.addAttribute("userName", userName);
		System.out.println(userName);
		// .. Cookie 정보를 이용해서 데이터 처리
		//기억하는 데이터를 가지고 응답하기
		return "/cookie/view";
	}
}
