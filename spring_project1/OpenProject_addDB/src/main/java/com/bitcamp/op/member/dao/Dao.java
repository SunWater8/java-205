package com.bitcamp.op.member.dao;

import java.util.List;

import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.SearchType;

public interface Dao {
	
	// 로그인
	Member selectByIdPw(String id, String pw);
	// 아이티 체크
	int selectById(String memberId);
	// 회원 가입
	int insertMember(Member member);
	// 회원 정보 수정
	int updateMember(Member member);
	// 회원 정보 삭제
	int deleteMember(int idx);
	// 회원 전체 리스트
	List<Member> selectAll();
	// 페이징 처리가 가능한 리스트
	List<Member> selectList(int startRow, int count); // (0,3).  시작 row와 한 페이지 당 몇 개씩 가져오는지를 담고 있음.
	// 전체 회원의 수
	int selectTotalCount(); //전체 회원수를 알아야 페이지 수를 알 수 있다.
	// 검색을 통한 회원 리스트
	List<Member> selectMember(SearchType searchType);
	
}








