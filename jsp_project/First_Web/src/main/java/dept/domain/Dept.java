package dept.domain;

public class Dept {
	//캡슐화 하여 변수 생성
	private int deptno;
	private String dname;
	private String loc;
	
	//생성자 만들기
	public Dept(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	
	//기본 생성자
	public Dept() {}

	//getter 와 setter 만들기 - 빈즈 객체 만들기 위해
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

	//디버깅 용으로 toString 만들기
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}
	
	
	
	
}
