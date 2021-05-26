package ch06;

public class Student {
	
	private String name;
	private int korTest;
	private int engTest;
	private int mathTest;
	
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setKorTest(int korTest) {
		this.korTest=korTest;
	}
	public int getKorTest() {
		return korTest;
	}
	public void setEngTest(int engTest) {
		this.engTest=engTest;
	}
	public int getEngTest() {
		return engTest;
	}
	public void setMathTest(int mathTest) {
		this.mathTest=mathTest;
	}
	public int getMathTest() {
		return mathTest;
	}
	
	Student(String name, int korTest, int engTest, int mathTest){
		this.name=name;
		this.korTest=korTest;
		this.engTest=engTest;
		this.mathTest=mathTest;
	}
	int sum=0;
	
	int total() {
		sum = korTest+engTest+mathTest;
		return sum;
	}
	float avg() {
		sum = korTest+engTest+mathTest;
		return sum/3;
	}
	
	public String toString() {
		return name+"의 총점은"+total()+"점 이고, 평균은"+ avg()+"점 입니다.";
		
	}
	public static void main(String[] args) {
		
		Student[] student = new Student[10];
		
//		Student stu = new Student();
		
		student[0] = new Student("홍길동",65,98,87);
		student[1] = new Student("정지수",85,45,97);
		student[2] = new Student("고길동",88,75,98);
		student[3] = new Student("둘리",25,33,64);
		student[4] = new Student("포켓몬",78,94,82);
		student[5] = new Student("스터",54,76,84);
		student[6] = new Student("이순신",27,54,68);
		student[7] = new Student("계백",85,95,87);
		student[8] = new Student("이창준",95,84,45);
		student[9] = new Student("지수현",67,68,75);
		
		for(int i=0; i<student.length;i++) {
			
			System.out.println(student[i]);
		}
		
	}
}
