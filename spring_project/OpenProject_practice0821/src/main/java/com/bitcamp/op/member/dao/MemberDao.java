package com.bitcamp.op.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.member.domain.Member;

@Repository
public class MemberDao {
	
	public Member selectByIdPw(Connection conn, String id, String pw) {
		
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from member where memberid=? and password=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setIdx(rs.getInt("idx"));
				member.setMemberid(rs.getString("memberid"));
				member.setPassword(rs.getString("password"));
				member.setMembername(rs.getString("membername"));
				member.setRegdate(rs.getTimestamp("regdate"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		
		
		
		return member;
	}

//	// ID 중복여부 확인을 위한 id 값으로 검색 -> 개수 반환
//	public int selectById(Connection conn, String memberId) throws SQLException {
//		
//		int cnt = 0;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		String sql = "select count(*) from member where memberid=?";
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, memberId);
//			
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				cnt = rs.getInt(1);
//			}
//			
//		} finally {
//			JdbcUtil.close(rs);
//			JdbcUtil.close(pstmt);
//		}
//		
//		return cnt;
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}