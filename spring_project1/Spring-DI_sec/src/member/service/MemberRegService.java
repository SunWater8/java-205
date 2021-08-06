package member.service;

import java.util.Date;

import member.dao.Dao;
import member.domain.Member;
import member.domain.RegRequest;

public class MemberRegService {
	//1
	Dao dao;
	//dao 는 인터페이스라서 이 클래스는 컴파일이 정상적으로 될 것이다.
	int num;
	//4.
	//property 방식 : setter 메소드를 이용, 기본 생성자가 필요하다.
	public void setDao(Dao dao) {
		this.dao=dao;
	}
	//2.
	//생성자 방식1
	//dao를 주입
	public MemberRegService(Dao dao) {
		this.dao = dao;
		System.out.println("MemberRegService 인스턴스 생성");
	}
	//7 기본 생성자
	public MemberRegService() {}
	
	//5
	//생성자 방식2. 기본형 정수 데이터를 받는 생성자
	public MemberRegService(int num) {
		System.out.println("MemberRegService 인스턴스 생성");
	}
	//6
	//생성자 방식3. 변수 여러개를 매개변수로 받기
	public MemberRegService(Dao dao, int num) {
		this.dao = dao;
		this.num = num;
		System.out.println("MemberRegService 인스턴스 생성");
	}
	
	//여기까지가 생성자///////////////////////////////////////////////
	//3.
	//회원 가입하기.
	public void regMember(RegRequest request) throws Exception {
		
		//중복 이메일을 체크하고 예외를 발생시키기
		Member member = dao.selectByEmail(request.getEmail());
		 if(member != null) {
			 throw new Exception();
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
