package ch11.MyCollectionFramework;

import java.util.*;

public class Football3TreeSet {
	public static void main(String[] args) {
		TreeSet<FootballPlayer2> set = new TreeSet<>();
		
		set.add(new FootballPlayer2("손흥민 ", 7, "tottonham", 30));
		set.add(new FootballPlayer2("이강인", 11, "tottonham", 20));
		set.add(new FootballPlayer2("이재규", 15, "bresell  ", 27));
		set.add(new FootballPlayer2("김진수", 17, "seoul    ", 30));
		set.add(new FootballPlayer2("이강인", 11, "tottonham", 20));
		set.add(new FootballPlayer2("박민규 ", 9, "Incheon  ", 25));
		set.add(new FootballPlayer2("김진수", 17, "seoul    ", 30));

	}
}
class FootballPlayer2 extends FootballPlayer implements Comparable<FootballPlayer2>{

	FootballPlayer2(String name, int number, String team, int age) {
		super(name, number, team, age);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(FootballPlayer2 o) {
		return super.getName().equals(o.name);
	}
	public void showData() {
		System.out.println("이름:"+super.getName()+", 등번호:"+getNumber()+", 소속팀:"+getTeam()+", 나이:"+getAge());
	}
	
}
