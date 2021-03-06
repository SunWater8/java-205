package member.main;

import member.dao.GuestDao;
import member.dao.MemberDao;
import member.service.ChangePasswordService;
import member.service.MemberRegService;

public class Assembler {

	/*
	컨테이너 : 인스턴스를 관리 -> 생성, 보관, 실행, 필요한 객체를 반환, 소멸
	조립기 클래스의 역할
	각각의 인스턴스를 생성
	의존 주입을 해준다.
	필요한 객체를 반환해 주는 기능
	*/
	
	// service 객체들을 컨테이너가 보관하기
	private MemberDao dao;
	private MemberRegService regService;
	private ChangePasswordService passwordService;
	
	private GuestDao gDao;

	//생성자
	public Assembler() {
		//인스턴스 만들 때 주입해주기 위해 dao 먼저 쓴다.
		//인스턴스를 생성 -> 의존 주입
		dao = new MemberDao();
		gDao = new GuestDao();
		
		//필요에 따라서 dao 를 gDao 를 골라 쓸 수 있다. 나머지 클래스의 코드는 바꿀 필요가 없이 여기 조립기 내부에서만 수정해도 되기에 편리하다.
		regService = new MemberRegService(dao); //dao 주입
		passwordService = new ChangePasswordService(dao); //dao 주입
	}

	//getter
	public MemberDao getDao() {
		return dao;
	}

	public MemberRegService getRegService() {
		return regService;
	}

	public ChangePasswordService getPasswordService() {
		return passwordService;
	}
	//Assembler를  통해서 하나의 객체를 가지고 변수를 사용 - 싱글톤 효과
	
}
