package com.bitcamp.op.member.domain;


public class LoginInfo {

	private int idx;
	private String memberid;
	private String password;
	private String memberphoto;
	public LoginInfo(int idx, String memberid, String password, String memberphoto) {
		super();
		this.idx = idx;
		this.memberid = memberid;
		this.password = password;
		this.memberphoto = memberphoto;
	}
	public int getIdx() {
		return idx;
	}
	public String getMemberid() {
		return memberid;
	}
	public String getPassword() {
		return password;
	}
	public String getMemberphoto() {
		return memberphoto;
	}
	@Override
	public String toString() {
		return "LoginInfo [idx=" + idx + ", memberid=" + memberid + ", password=" + password + ", memberphoto="
				+ memberphoto + "]";
	}
	
	
	
}
