package com.bitcamp.op.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.op.member.domain.MemberRegRequest;
import com.bitcamp.op.member.service.MemberRegService;

@Controller
@RequestMapping("/member/reg")
public class MemberRegController {

	@Autowired
	private MemberRegService regService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String regForm() {
		return "/member/regForm";
	}
	
	@RequestMapping (method=RequestMethod.POST)
	public String reg(
			
			@ModelAttribute("regRequest") MemberRegRequest regRequest, //@ModelAttribute 없이 reg.jsp가서 el로 호출할 경우 전달할 객체이름 첫 글자를 소문자로 바꾸어 ${memberRegRequest}라고 쓰면 되고, 만일 다르게 쓰고 싶다면 @ModelAttribute를 사용해서 괄호 안에 있는 이름으로 전달해 쓰면 된다.
			HttpServletRequest request,
			Model model
			) { 
		
		int result =  regService.memberReg(regRequest, request);
		model.addAttribute("result", result);
		
		//view 지정하기!
		String view = "member/reg"; //view 변수의 기본 경로
		
		if(result == 1) {
			//순조롭게 회원가입이 성공하면 이 곳으로 view 보여주기
			view="redirect:/index";
		}
		return view;
	}
} 
