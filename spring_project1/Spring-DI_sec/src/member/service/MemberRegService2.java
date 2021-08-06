package member.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import member.dao.Dao;
import member.domain.Member;
import member.domain.RegRequest;

public class MemberRegService2 {

	//@Autowired(required = false) - required는 최대한 안 쓰는 것이 좋다.
	@Autowired
	@Qualifier("member")
	
	//@Resource(name = "guestDao") - autowired를 더 많이 쓴다.
	private Dao dao;
	
	
	
	//2.
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
