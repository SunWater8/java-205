package member.domain;

public class Member {

	private int idx;
	private String userid;
	private String pw;
	private String name;
	private String joindate;
	public Member(int idx, String userid, String pw, String name, String joindate) {
		super();
		this.idx = idx;
		this.userid = userid;
		this.pw = pw;
		this.name = name;
		this.joindate = joindate;
	}
	
	
	public Member(String userid, String pw, String name) {
		this.userid = userid;
		this.pw = pw;
		this.name = name;
	}


	public Member() {}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	@Override
	public String toString() {
		return "Member [idx=" + idx + ", userid=" + userid + ", pw=" + pw + ", name=" + name + ", joindate=" + joindate
				+ "]";
	}
	
}
