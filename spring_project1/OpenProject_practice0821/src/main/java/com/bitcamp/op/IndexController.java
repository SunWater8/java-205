package com.bitcamp.op;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public void index() {
	}
	
	@RequestMapping("/")
	public String indexPage() {
		System.out.println("/진입");
		return "redirect:/index";
	}
}
