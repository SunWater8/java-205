package com.bitcamp.firstSpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeaderController {

	@RequestMapping("/header/header")
	public String getHeader(
			//이전에 있던 페이지의 경로 가지고 오기 - referer는 이전의 url을 의미함, header는 어딘가로 향한다는 뜻.
			@RequestHeader("referer") String reString, //괄호 안에 required와 defaultValue 쓸 수도 있다.
			Model model
			){
		System.out.println(reString);
		model.addAttribute("re", reString);
		
		return "header/headerInfo";
		
		
		//리다이렉트 뷰로 처리 : 지정한 페이지로 리다이렉트 됨
		//return "redirect:/member/login";
	}
	
}
