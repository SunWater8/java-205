package com.bitcamp.firstSpring.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberMypageController {

	@RequestMapping("/member/mypage/{id}")
	public String mypage(
			@PathVariable("id") String userId,
			Model model
			) {
		model.addAttribute("uid", userId);
		return "member/mypage";
	}
}
