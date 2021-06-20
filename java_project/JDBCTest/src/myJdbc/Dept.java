
//사용자에게서 입력받은 데이터를 가지고 저장.
// 이 클래스의 용도는 사용자가 입력하는 데이터를 dept에 넣어서 처리하려고 한다.
//db에 있는 dept 테이블도 class dept로 만들어서 저장해 좋을 것이다.
//부서 정보를 저장하는 기능 클래스

package myJdbc;

public class Dept {
	
		
	private int deptno; //부서번호
	private String dname; //부서이름
	private String loc; //부서위치
	
	public Dept(int deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	//디버깅의 목적으로 toString 메소드 생성.
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}
		
	
}
