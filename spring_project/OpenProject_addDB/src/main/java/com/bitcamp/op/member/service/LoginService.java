package com.bitcamp.op.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.member.dao.Dao;
import com.bitcamp.op.member.dao.JdbcTemplateMemberDao;
import com.bitcamp.op.member.dao.mybatisMemberDao;
import com.bitcamp.op.member.domain.Member;

@Service
public class LoginService {

	//@Autowired
	//MemberDao dao;
	
	//@Autowired
	//private JdbcTemplateMemberDao dao;
	
	//@Autowired
	//private mybatisMemberDao dao;
	
	//인터페이스 Dao를 이용하기 위해서는 SqlSessionTemplate의 getMapper가 필요하기에 이 객체를 주입받기.
	@Autowired
	private SqlSessionTemplate template;
	
	//인터페이스를 이용한 dao를 주입받기.
	private Dao dao;
	
	public boolean login(
			String id, 
			String pw, 
			String reid, 
			HttpSession session, 
			HttpServletResponse response) {
		
		boolean loginChk = false;
		
		//Connection conn = null;
		
		// 인터페이스 Dao 구현체인 Mapper를 사용하기
		dao = template.getMapper(Dao.class);
		
		System.out.println("인터페이스 메퍼 dao 생성"); //확인하기 위한 용도
		
		// 전달받은 id와 pw 로 DB에서 검색 
		// => 있다면 로그인 처리 true return
		// => 없다면 false return
		Member member = dao.selectByIdPw(id, pw);
		
		if(member != null) {
			// 로그인 처리
			session.setAttribute("loginInfo", member.toLoginInfo());
			
			loginChk = true;
		}
		
		// 아이디 저장을 위한 Cookie 설정
		if(reid != null && reid.length() > 0) {
			Cookie cookie = new Cookie("reid", id);
			cookie.setPath("/");
			cookie.setMaxAge(60*60*24*365);
			
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("reid", id);
			cookie.setPath("/");
			cookie.setMaxAge(0);
			
			response.addCookie(cookie);
		}
				
		return loginChk;
	}
}
