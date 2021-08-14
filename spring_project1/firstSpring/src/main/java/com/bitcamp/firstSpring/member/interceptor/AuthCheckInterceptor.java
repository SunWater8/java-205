package com.bitcamp.firstSpring.member.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter {
	/*HandlerInterceptor인터페이스를 구현한 HandlerInterceptorAdapter를 상속하는 클래스를 만들어서
		HandlerInterceptor 인터페이스에서 사용하고자 하는 메소드만 뽑아서 쓰도록 한다. 
		중간에 HandlerInterceptorAdapter 메소드를 상속하지 않고 바로 인터페이스를 구현한다면 
		이 인터페이스가 가지는 모든 메소드를 사용해야 하는 문제가 있어서다.*/
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//mypage가 포함된 경로를 들어오게 되면 다음의 문장 출력이 됨.
		//System.out.println("AuthCheckInterceptor preHandle() 진입");
		
		// 1. 로그인 여부 확인
		// 2. 로그인 상태에 따라서 true 혹은 false로 return - 로그인 상태라면 controller 실행시키고, 로그인 상태가 아니라면 controller 실행시키지 않음.
		// 3. 로그인 상태가 아니라면 로그인 페이지로 redirect
		
		//로그인 상태 확인하기 - 현재의 세션 가져오기
		HttpSession session = request.getSession(false);
		
		if(session != null && session.getAttribute("loginInfo") != null) {
			//로그인 상태일 때 true.다음 요청을 이어 나간다.- 다음의 인터셉터나 controller로 보내서 실행하도록 한다.
			return true;
		}
		
		//로그인 상태가 아니라면 로그인하라는 화면으로 보내기 - redirect
		response.sendRedirect(request.getContextPath()+"/member/login");
		return false;
		
	}

}
