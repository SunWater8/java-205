package com.bitcamp.firstSpring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {
	
	private String str;
	
	@RequestMapping("/error/error")
	public String getPage() {
		
		System.out.println(str.charAt(0));
		//주입이 정상적으로 되지 않을 경우 널포인터 예외가 발생할 것이다.
		return "index";
	}
	
	//null pointer 예외 발생하면 이 메소드가 실행된다
	@ExceptionHandler(NullPointerException.class)
	public String handleNullPointerException(NullPointerException e) {
		e.printStackTrace();
		return "error/nullPointer";
	}
}
