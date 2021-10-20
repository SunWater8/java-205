package member.service;

import member.dao.Dao;
import member.domain.Member;

public class ChangePasswordService {

	Dao dao;
	
	//생성자 초기화를 통해 Dao 주입하기
	public ChangePasswordService(Dao dao) {
		this.dao = dao;
		System.out.println("ChangePasswordService 인스턴스 생성");
	}
	
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
