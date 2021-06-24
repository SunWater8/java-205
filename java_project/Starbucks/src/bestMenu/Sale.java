package bestMenu;

public class Sale {
	
	private int salecode;
	private String sname;
	private int price;
	private String saledate;
	private int count; // 새로운 변수 추가 (판매 횟수를 카운트 함)
	
	
	public Sale(int salecode, String sname, int price, String saledate) {
		this. salecode = salecode;
		this.sname = sname;
		this.price= price;
		this.saledate = saledate;
	}
	
	public Sale(int salecode, String sname, int price) {
		this. salecode = salecode;
		this.sname = sname;
		this.price= price;
	}
	
	public Sale( String sname, int price) { 
		this.sname = sname;
		this.price= price;
	}
	
	
	//순위 매기기 위한 생성자
	public Sale(   int count, String sname) {
		this.sname = sname;
		this.count = count;
	}

	public int getSalecode() {
		return salecode;
	}

	public void setSalecode(int salecode) {
		this.salecode = salecode;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSaledate() {
		return saledate;
	}

	public void setSaledate(String saledate) {
		this.saledate = saledate;
	}
	//count 변수의 getter/setter
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	

	
	
}