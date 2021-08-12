package com.bitcamp.firstSpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeaderController {

	@RequestMapping("/header/header")
	public String getHeader(
			@RequestHeader("referer") String reString,
			Model model
			){
		System.out.println(reString);
		model.addAttribute("re", reString);
		
		//return "header/headerInfo";
		//리다이렉트 뷰로 처리 : 지정한 페이지로 리다이렉트 됨
		return "redirect:/member/login";
	}
	
}
