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
	@RequestMapping("/cookie/make")
	public String makeCookie(HttpServletResponse response) {
	//쿠키 등록하기 위해서는 원래 response 필요함.
		Cookie c = new Cookie("username", "KING");
		//식별할 수 있는 쿠키 이름 : username, 쿠키 값: KING (이런 식의 논리 과정은 나중에 service 클래스에서 처리하도록 하기)
		
		//사용자 쪽으로 만든 쿠키를 보내줌.
		response.addCookie(c);
		
		//특정 서비스에 특정 메소드를 이용해서 쿠키를 보내줄 수도 있다.
		//Service.process(response); // <- 임의로 만든 문장
		
		return "cookie/make";
	}
	
	
	@RequestMapping("/cookie/view")
	public String viewCookie(
			//쿠키설정1
			//이 메소드가 호출이 되면 기존에 있던 "username"이라는 쿠키 값을 가져와서 전달해준다. 전달을 받을 때 string 타입으로 받도록 한다.
			//@CookieValue("username") String userName,
			
			//쿠키설정2
			//required 가 true 라면 필수적으로 값이 지정되어 있어야 하기 때문에 400번 에러가 발생, false면 필수 아니라서 값이 없어도 정상적으로 페이지가 작동이 된다.
			//value에 usernames 라는 값은 없고 username만 있기 때문에 오류가 발생할 수 있다. 
			//@CookieValue(value = "usernames", required = false) String userName,
			
			//쿠키설정3
			//쿠키 usernames가 원래 없다면 defaultvalue를 scott 이라고 기본설정을 한다.
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
