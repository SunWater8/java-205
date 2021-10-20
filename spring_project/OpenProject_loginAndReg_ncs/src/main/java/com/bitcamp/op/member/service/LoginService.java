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

@Service //이 서비스 클래스를 bean으로 등록하기
public class LoginService {

	@Autowired
	MemberDao dao;

	public boolean login(String id, String pw, String reid, HttpSession session, HttpServletResponse response) {
		boolean loginChk = false;

		// 전달받은 id와pw로 db에서 검색하고(select) 있다면 로그인 처리 true return, 없다면 false return
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			Member member = dao.selectByIdPw(conn, id, pw);

			if (member != null) {
				// 로그인 처리
				session.setAttribute("loginInfo", member.toLoginInfo()); // 로그인 정보를 세션에 저장하기
				loginChk = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 아이디 저장을 위한 Cookie 설정하기
		if (reid != null && reid.length() > 0) {
			Cookie cookie = new Cookie("reid", reid);
			cookie.setPath("/");
			cookie.setMaxAge(60 * 60 * 24 * 31);

			response.addCookie(cookie);
		}else { //쿠키 설정 안하고 싶으면 max age를 0으로 하면 된다.
			Cookie cookie = new Cookie("reid", reid);
			cookie.setPath("/");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		return loginChk;
	}
}
