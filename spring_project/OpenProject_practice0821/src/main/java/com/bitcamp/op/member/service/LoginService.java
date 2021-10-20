package com.bitcamp.op.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.domain.Member;

@Service
public class LoginService {

	@Autowired
	private MemberDao dao;
	
	public boolean login(
			String id,
			String pw,
			String reid,
			HttpServletResponse response,
			HttpSession session
			) {
		boolean loginChk = false;
		Connection conn = null;
		try {
			
			conn = ConnectionProvider.getConnection();
			Member member = dao.selectByIdPw(conn,id, pw);
		
			if(member != null ) {
				session.setAttribute("loginInfo", member.toLoginInfo());
				loginChk = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(reid.length()>0 && reid != null) {
			Cookie cookie = new Cookie("reid",reid);
			cookie.setPath("/");
			cookie.setMaxAge(60*60*24*7);
			response.addCookie(cookie);
		}else {
			Cookie cookie = new Cookie("reid",reid);
			cookie.setPath("/");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		return loginChk;
	}
}
