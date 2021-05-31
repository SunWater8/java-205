package ch06;

public class Student {

	private String name;
	private int korTest;
	private int engTest;
	private int mathTest;

	public Student() {
	}

	public Student(String name, int korTest, int engTest, int mathTest) {
		this.name = name;
		this.korTest = korTest;
		this.engTest = engTest;
		this.mathTest = mathTest;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setKorTest(int korTest) {
		this.korTest = korTest;
	}

	public int getKorTest() {
		return korTest;
	}

	public void setEngTest(int engTest) {
		this.engTest = engTest;
	}

	public int getEngTest() {
		return engTest;
	}

	public void setMathTest(int mathTest) {
		this.mathTest = mathTest;
	}

	public int getMathTest() {
		return mathTest;
	}

	int total() {
		return this.korTest + this.engTest + this.mathTest;
	}

	float avg() {
		return total() / 3f;
	}

}
