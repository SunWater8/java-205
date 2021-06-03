package ch12;

import java.io.*;
import java.util.*;

class FootballPlayer implements Serializable {
	private String name;
	private int number;
	private String team;
	private int age;

	public FootballPlayer(String name, int number, String team, int age) {
		this.name = name;
		this.number = number;
		this.team = team;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() { // 참조변수 출력하기
		return "FootballPlayer [name=" + name + ", number=" + number + ", team=" + team + ", age=" + age + "]";
	}
}

public class FootballList {

	public static void main(String[] args) {
		// ① 축구선수 정보 인스턴스를 List<E>에 저장하는 프로그램을 만들어 봅시다.
		// ② 이 인스턴스 들을 파일로 저장하는 기능을 만들어 봅시다.
		// ③ 저장된 파일을 객체로 만드는 기능을 만들어봅시다.

		try {
			System.out.println("작업 시작");
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("FootballPlayerList.txt"));
			List<FootballPlayer> list = new ArrayList<>();

			list.add(new FootballPlayer("손흥민 ", 7, "tottonham", 30));
			list.add(new FootballPlayer("이강인", 11, "tottonham", 20));
			list.add(new FootballPlayer("이재규", 15, "bresell  ", 27));
			list.add(new FootballPlayer("김진수", 17, "seoul    ", 30));
			list.add(new FootballPlayer("이강인", 11, "tottonham", 20));
			list.add(new FootballPlayer("박민규 ", 9, "Incheon  ", 25));
			list.add(new FootballPlayer("김진수", 17, "seoul    ", 30));
			out.writeObject(list);
			out.close();
			System.out.println("작업 완료");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
