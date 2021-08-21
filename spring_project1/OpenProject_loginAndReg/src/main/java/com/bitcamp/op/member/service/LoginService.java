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

	//로그인 되었는지 안되었는지 결과를 반환해야 하기 때문에 boolean을 반환타입으로 사용.
	public boolean login(String id, String pw, String reid, HttpSession session, HttpServletResponse response) {
		boolean loginChk = false;

		//Member 객체에 dao를사용한 메소드를 입력 후 connection을 연결해주면 된다.
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			// 전달받은 id와 pw를 dao를 가지고 db에서 검색하고(select) 
			// => 있다면 로그인 처리 true return, 
			// => 없다면 false return 해주기
			Member member = dao.selectByIdPw(conn, id, pw);

			if (member != null) { //member 내용이 들어 있다면...이라는 뜻.
				// 로그인 처리- 로그인 정보(loginInfo)를 세션에 저장하기
				session.setAttribute("loginInfo", member.toLoginInfo()); 
				loginChk = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 아이디 저장을 위한 Cookie 설정하기
		if (reid != null && reid.length() > 0) {//체크를 했다면..이라는 뜻.ㄴ
			Cookie cookie = new Cookie("reid", reid); //이렇게 설정된 reid는 loginForm.jsp에서 memberid의 값으로 불러오기 위함이다.
			cookie.setPath("/");//로컬호스트로 들어오는 모든 경로에 이 쿠키가 적용됨.
			cookie.setMaxAge(60 * 60 * 24 * 7); //쿠키의 생명주기 (일주일)

			response.addCookie(cookie);
		}else { //쿠키 설정 안하고 싶으면 기존에 있던 쿠키를 풀기 위해 max age를 0으로 하면 된다.
			Cookie cookie = new Cookie("reid", reid);
			cookie.setPath("/");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		return loginChk;
	}
}
