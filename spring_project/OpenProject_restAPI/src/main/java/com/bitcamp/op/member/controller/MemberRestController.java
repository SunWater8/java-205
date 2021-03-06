package com.bitcamp.op.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.MemberRegRequest;
import com.bitcamp.op.member.service.MemberRegService;
import com.bitcamp.op.member.service.MemberRestService;

//@Controller
@RestController
public class MemberRestController {
	@Autowired
	private MemberRestService restService;
	
	@Autowired
	private MemberRegService regService;

	@RequestMapping("/members/{id}")
	public Member getMember(@PathVariable("id") int idx) {
		Member member = restService.getMember(idx);
		System.out.println(member);
		return member;
	}
	
	@GetMapping("/members")
	public List<Member> getMembers(){
		return restService.getMembers();
	}
	
	@PostMapping("/members/reg1")
	public String regMember1(
			MemberRegRequest regRequest,
			HttpServletRequest request
			) {
		System.out.println(regRequest);
		return Integer.toBinaryString(regService.memberReg(regRequest,  request));
	}
	
	
	
	
}
