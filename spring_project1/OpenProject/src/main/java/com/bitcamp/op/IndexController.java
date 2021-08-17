package com.bitcamp.op;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public void index() {
	}
	//반환타입을 void 로 했기 때문에 자동으로 index.jsp 로 찾아가게 된다.
	
	@RequestMapping("/")
	public String index1() {
		System.out.println("/진입");
		return "redirect:/index";
	}
}
