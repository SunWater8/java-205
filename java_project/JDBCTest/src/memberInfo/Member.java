package memberInfo;

public class Member {
	private int memcode;
	private String name;
	private String id;
	private String pw;
	private String address;
	private String phone;
	private int point;
	
	//관리자가 회원들 정보 조회할 때 필요한 생성자
	public Member(int memcode, String name, String id, String pw, String address, String phone, int point) {
		this.memcode = memcode;
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.address = address;
		this.phone = phone;
		this.point = point;
	}
	//회원이 정보 조회할 때 필요한 생성자
	public Member(String name, String id, String pw, String address, String phone, int point) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.address = address;
		this.phone = phone;
		this.point = point;
	}
	//회원이 정보 수정할 때 필요한 생성자
	public Member(String id, String pw, String address, String phone) {
		this.id = id;
		this.pw = pw;
		this.address = address;
		this.phone = phone;
	}


	public Member(String id) {
		this.id=id;
	}
	public int getMemcode() {
		return memcode;
	}
	public void setMemcode(int memcode) {
		this.memcode = memcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "Member [memcode=" + memcode + ", name=" + name + ", id=" + id + ", pw=" + pw + ", address=" + address
				+ ", phone=" + phone + ", point=" + point + "]";
	}
	
	
}