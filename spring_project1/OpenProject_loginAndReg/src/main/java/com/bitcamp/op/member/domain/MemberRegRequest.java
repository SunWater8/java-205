//사용자가 요청하는 데이터를 바인딩해서 가지고 있는 객체
package com.bitcamp.op.member.domain;

import org.springframework.web.multipart.MultipartFile;

public class MemberRegRequest {

	//회원가입 입력에 필요한 변수들
	private String memberid;
	private String password;
	private String membername;
	private MultipartFile photo;
	
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	
	@Override
	public String toString() {
		return "RegRequest [memberid=" + memberid + ", password=" + password + ", membername=" + membername
				+ ", photo=" + photo.getOriginalFilename() + "]";
		//photo.getOriginalFilename()라고 해야 사용자가 업데이트한 파일의 원래 이름을 가져올 수 있다.
	}
	
	//서비스에서 dao로 전달하기 위해서 member 객체의 형태로 만들어 주기.( Member객체 타입으로 반환)
	//사용자가 입력한 데이터만 Member 객체 형태로 저장할 것이기 때문에 추가로 저장하려는 idx와 regDate의 값은 의미가 없기 때문에 0이나 null 값으로 임의로 입력해도 상관 없다. 
	public Member toMember() {
		return new Member(0, memberid, password, membername, photo.getOriginalFilename(),null);
	}
}