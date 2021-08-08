package com.bitcamp.firstSpring.member.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 1. 로그인 여부 확인
		// 2. 로그인 상태에 따라서 true 혹은 false로 return
		// 3. 로그인 상태가 아니라면 로그인 페이지로 redirect
		
		//로그인 상태 확인하기
		HttpSession session = request.getSession(false);
		
		if(session != null && session.getAttribute("login") != null) {
			//로그인 상태일 때 true.다음 요청을 이어 나간다.
			return true;
		}
		
		//로그인 상태가 아니라면 로그인하라는 화면으로 보내기
		response.sendRedirect(request.getContextPath()+"/member/login");
		return false;
		
	}

}
