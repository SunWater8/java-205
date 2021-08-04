package domain;
//my page 에서 보여질 정보들의 묶음들.
public class LoginInfo {
	
	private int idx;
	private String memberId;
	private String memberName;
	
	//별도의 객체를 만들어 사용해야 하기 때문에 기본 생성자는 만들지 않을 것이다.
	public LoginInfo(int idx, String memberId, String memberName) {
		this.idx = idx;
		this.memberId = memberId;
		this.memberName = memberName;
	}
	
	//로그인 후 회원의 정보는 세션에서 바뀌면 안되기 때문에 setter는 오버로딩 하지 않을 것이다. - vo의 개념.
	public int getIdx() {
		return idx;
	}
	public String getMemberId() {
		return memberId;
	}
	public String getMemberName() {
		return memberName;
	}

	@Override
	//데이터를 확인해 볼 이유로 toString 만들기
	public String toString() {
		return "LoginInfo [idx=" + idx + ", memberId=" + memberId + ", memberName=" + memberName + "]";
	}
	
	
}
