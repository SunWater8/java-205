package com.bitcamp.op.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.member.dao.MemberDao;

@Service
public class IdCheckService {
	
	@Autowired
	MemberDao dao;
	
	public String idCheck(String id) { //Y 또는 N으로 반환하기 위해 이 메소드의 반환타임으로 String 사용
		
		String result = "Y";
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			if(dao.selectById(conn, id)>0) { //db에 아이디 값이 있으면 n을 반환하기
				result="N";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}