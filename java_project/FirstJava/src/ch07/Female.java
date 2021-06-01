package ch07;

class Female extends Person{
	private String hairColor;
	Female(){}
	Female(String name, String personNum, String hairColor) {
		super(name, personNum);
		this.hairColor=hairColor;
	}
	
	
	
	public String getHairColor() {
		return hairColor;
	}
	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}
	void watching() {
		System.out.println("그녀는 영화를 보고 있다.");
	}
	
	void greeting(){
		System.out.println("안녕하세요. 저는 "+getName()+"입니다. "+age()+"살 입니다. 제 머리 색은 "+getHairColor()+"입니다.");
	}
}
	