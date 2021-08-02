package member.service;

import java.util.Date;

import member.dao.Dao;
import member.domain.Member;
import member.domain.RegRequest;

public class MemberRegService {

	Dao dao;
	//dao 는 인터페이스라서 이 클래스는 컴파일이 정상적으로 될 것이다.
	
	//dao를 주입
	public MemberRegService(Dao dao) {
		this.dao = dao;
		System.out.println("MemberRegService 인스턴스 생성");
	}
	
	public void regMember(RegRequest request) throws Exception {
		//중복 이메일을 체크하고 예외를 발생시키기
		//기존의 멤버
		Member member = dao.selectByEmail(request.getEmail());
		 if(member != null) {
			 throw new Exception("중복 이메일!");
		 }
				
		
		Member newMember = new Member(
				0,
				request.getEmail(),
				request.getPassword(),
				request.getName(),
				new Date());
		dao.insert(newMember);
	}
	//
}
