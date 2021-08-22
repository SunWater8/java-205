package com.bitcamp.op.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.SearchIdPw;

@Repository
public class mybatisMemberDao {

	@Autowired
	private SqlSessionTemplate template;
	
	//자주쓰이는 변수를 메소드 앞에 상수로 선언하기. memberMapper.xml에서 mapper의 namespace를 뜻함.
	private final String NAME_SPACE = "com.bitcamp.op.member.dao.memberMapper"; 

	public int insertMember(Member member) throws SQLException {
		return template.update(NAME_SPACE+".insertMember", member);
	}

	//회원가입을 위한 메소드
	public int insertMember1(final Member member) throws SQLException {

		int resultCnt = 0;
		
		// 자동 증가한 컬럼의 값을 저장할 객체
//		KeyHolder holder = new GeneratedKeyHolder();
//		
//		resultCnt = template.update(
//				new PreparedStatementCreator() {
//					
//					@Override
//					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//						String sql2 = "insert into member (memberid,password,membername, memberphoto) values (?, ?, ?,?)";
//						PreparedStatement pstmt = con.prepareStatement(sql2, new String[] {"idx"});
//						pstmt.setString(1, member.getMemberid());
//						pstmt.setString(2, member.getPassword());
//						pstmt.setString(3, member.getMembername());
//						pstmt.setNString(4, member.getMemberphoto());
//						return pstmt;
//					}
//				}
//				, holder);
//		
//		Number idx = holder.getKey();
//		member.setIdx(idx.intValue());
		
		return resultCnt;

	}

	public List<Member> selectList(Connection conn) {

		List<Member> list = null;

//		try {
//			stmt = conn.createStatement();
//
//			String sql = "select * from member";
//
//			rs = stmt.executeQuery(sql);
//
//			list = new ArrayList<Member>();
//
//			while (rs.next()) {
//				list.add(new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
//						rs.getTimestamp(6)));
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			JdbcUtil.close(rs);
//			JdbcUtil.close(stmt);
//		}

		return list;

	}
	//로그인을 위한 메소드.
	public Member selectByIdPw(String id, String pw) {
		
		//여러줄로 만든 버전
		//Member member = template.selectOne(NAME_SPACE+".selectByIdPw",new SearchIdPw(id, pw));
		//return member;
		
		//한 줄로 만든 버전
		return template.selectOne(NAME_SPACE+".selectByIdPw",new SearchIdPw(id, pw));
		//
		//memberMapper.xml에서의 id가 selectByIdPw인 sql을 이용하기.
		//매개변수로 받은 id와 pw를 같이 반환하려면 map이나 클래스 타입으로 묶어 주어야 해서 SearchIdPw 클래스를 이용함.
	}

	// ID 중복여부 확인을 위한 id 값으로 검색 -> 개수 반환
	public int selectById(String memberId) throws SQLException { //비록 memberMapper.xml에서 selectById가 반환하는 것이 Integer 타입이지만 자바에서는 autoboxing/unboxing 덕분에 자동으로 int타입으로 바꿔주기 때문에 여기에서는 편안하게 int라는 반환타입을 써도 된다.
		return template.selectOne(NAME_SPACE+".selectById", memberId);
	}

}
