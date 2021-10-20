package com.bitcamp.op.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.member.domain.Member;

@Repository
public class JdbcTemplateMemberDao {

	@Autowired
	private JdbcTemplate template;

	public int insertMember(Member member) throws SQLException {

		int resultCnt = 0;
		String sql1 = "insert into member (memberid,password,membername) values (?, ?, ?)";
		String sql2 = "insert into member (memberid,password,membername, memberphoto) values (?, ?, ?,?)";

		if (member.getMemberphoto() != null) {
			resultCnt = template.update(sql2, member.getMemberid(), member.getPassword(), member.getMembername(), member.getMemberphoto());
		} else {
			resultCnt = template.update(sql1, member.getMemberid(), member.getPassword(), member.getMembername());
		}

		return resultCnt;

	}

	public int insertMember1(final Member member) throws SQLException { //final을 붙인 이유 : insert 하는 시점과 generate 하는 시점을 달리할 수 있다. (생명주기 문제 해결)

		int resultCnt = 0;
		
		// 자동 증가한 컬럼의 값을 저장할 객체
		KeyHolder holder = new GeneratedKeyHolder();
		
		resultCnt = template.update(new PreparedStatementCreator() {
					
					//익명클래스 생성
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						String sql2 = "insert into member (memberid,password,membername, memberphoto) values (?, ?, ?,?)";
						PreparedStatement pstmt = con.prepareStatement(sql2, new String[] {"idx"}); //컬럼이 idx인 값들을 자동증가해서 holder에 넣어줄 수 있다. 
						pstmt.setString(1, member.getMemberid());
						pstmt.setString(2, member.getPassword());
						pstmt.setString(3, member.getMembername());
						pstmt.setNString(4, member.getMemberphoto());
						return pstmt;
					}
				}
				, holder); //holder에 값을 넣어주기.
		
		Number idx = holder.getKey(); //입력된 값을 가져오기(자동증가된 값)
		//업데이트가 끝나고 int 타입의 값으로 받아서 전달하기.
		member.setIdx(idx.intValue());
		
		return resultCnt;

	}

	public List<Member> selectList(Connection conn) {

		List<Member> list = null;

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();

			String sql = "select * from member";

			rs = stmt.executeQuery(sql);

			list = new ArrayList<Member>();

			while (rs.next()) {
				list.add(new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getTimestamp(6)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}

		return list;

	}

	public Member selectByIdPw(String id, String pw) {

		//길게 쓴 버전
		String sql = "select * from member where memberid=? and password=?";
		List<Member> list = template.query(sql, new MemberRowMapper(), id, pw);
		Member member = list.isEmpty() ? null : list.get(0); //id는 유니크한 속성을 가지고 있기 때문에 중복되는 아이디가 없거나(null) 하나만(list.get(0)-일치하는 첫번째 아이디) 있을 수 있다. 두개 이상은 있을 수 없다는 말.
		return member;
		
		//두 줄로 요약한 버전.
		//List<Member> list = template.query("select * from member where memberid=? and password=?", new MemberRowMapper(), id, pw);
		//return list.isEmpty() ? null : list.get(0);
	}

	// ID 중복여부 확인을 위한 id 값으로 검색 -> 개수 반환
	public int selectById(String memberId) throws SQLException {
		//길게 쓴 버전.
		String sql= "select count(*) from member where memberid=?" ;
		int cnt = template.queryForObject(sql, Integer.class, memberId);;
		return cnt;
		
		//한 줄로 요약한 버전
		//return template.queryForObject("select count(*) from member where memberid=?", Integer.class, memberId);
	}

}
