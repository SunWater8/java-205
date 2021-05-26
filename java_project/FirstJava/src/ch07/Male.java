package ch07;

class Male extends Person{
	
	private String driveLi;
	public String getDriveLi() {
		return driveLi;
	}
	public void setDriveLi(String driveLi) {
		this.driveLi = driveLi;
	}
	Male(){}
	Male(String name, String personNum,String driveLi) {
		super(name, personNum);
		this.driveLi=driveLi;
	}
	
	public void driving() {
		System.out.println("그는 그의 차를 운전해서 퇴근하고 있다.");
	}
	
	void greeting(){
		System.out.println("안녕하세요. 저는 "+getName()+"입니다. "+age()+"살 입니다."+" 저는 면허 "+getDriveLi()+" 자격을 가지고 있습니다.");
	}
}