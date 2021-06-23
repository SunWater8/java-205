
public class Admin {
	private int idx;
	private String id;
	private String pw;
	public Admin(int idx, String id, String pw) {
		super();
		this.idx = idx;
		this.id = id;
		this.pw = pw;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
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
	@Override
	public String toString() {
		return "Admin [idx=" + idx + ", id=" + id + ", pw=" + pw + "]";
	}
	
	
}
