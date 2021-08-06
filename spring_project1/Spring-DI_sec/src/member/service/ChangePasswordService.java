package member.service;

import member.dao.Dao;
import member.domain.Member;

public class ChangePasswordService {
	// 1. 인터페이스 Dao
	// 4. private으로 하기
	private Dao dao;
	
	// 6. property 방식의 주입 : setter 메소드를 이용, 기본 생성자가 필요
	public void setDao(Dao dao) {
		this.dao=dao;
	}
	// 5. 기본 생성자
	//setter 방식으로 주입하려면 꼭 기본 생성자가 필요하다.
	public ChangePasswordService() {
		System.out.println("ChangePasswordService()");
	}
	// 2. dao 주입하는 생성자
	//생성자 초기화를 통해 Dao 주입하기
	public ChangePasswordService(Dao dao) {
		this.dao = dao;
		System.out.println("ChangePasswordService 인스턴스 생성");
	}
	// 3. 메소드
	//바꾸고자 하는 대상을 찾기 위해 email, 비밀번호 입력하라고 확인하기 위한 oldPw, 바꾸고자 하는 새로운 비밀번호 newPw
	public void changePassword(String email, String oldPw, String newPw) throws Exception {
		//email이 정상적으로 받아지는지 확인하기
		System.out.println(email);
		
		Member member = dao.selectByEmail(email);
		
		if(member == null) {
			throw new Exception("존재하지 않는 회원!");
		}
		
		member.changePassword(oldPw, newPw);
		
		dao.update(member);
	}
}


