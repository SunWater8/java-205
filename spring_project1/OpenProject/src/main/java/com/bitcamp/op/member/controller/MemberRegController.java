package com.bitcamp.op.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.member.service.MemberRegService;

@Controller
@RequestMapping("/member/Reg")
public class MemberRegController {

	@Autowired
	private MemberRegService regService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String regForm(
			) {
		return "/member/RegForm";
	}
	
	public String reg(
			@RequestParam("memberid") String memberid,
			@RequestParam("password") String password,
			@RequestParam("membername") String membername,
			@RequestParam("memberphoto") String memberphoto,
			Model model
			) {
		
		boolean reg =  regService.reg(memberid, password, membername, memberphoto);
		model.addAttribute("reg", reg);
		
		return "member/memberReg";
	}
}
