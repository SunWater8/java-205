package member.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import member.domain.Member;

public class MemberDao implements Dao {

	//0부터 아이디가 시작 됨.
	private static int nextid = 0;
	
	//String타입의 email과 member 객체를 저장
	private Map<String, Member> map = new HashMap<>();
	
	//이 컨테이너가 생성자를 만드는지 확인해보는 생성자
	public MemberDao() {
		System.out.println("MemberDao 인스턴스 생성");
	}
	
	
	@Override
	public Member selectByEmail(String email) {
		return map.get(email);
	}

	@Override
	public void insert(Member member) {
		//최초에는 0이었다가 증가시킴
		member.setId(nextid++);
		
		map.put(member.getEmail(), member);
	}

	@Override
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}

	@Override
	public Collection<Member> selectAll() {
		//key, value 형식으로 그대로 출력하는 메소드
		return map.values();
	}

}
