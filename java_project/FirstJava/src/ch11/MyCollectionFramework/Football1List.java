package ch11.MyCollectionFramework;

import java.util.*;

public class Football1List {

	public static void main(String[] args) {
		List<FootballPlayer> list = new ArrayList<>();

		list.add(new FootballPlayer("손흥민 ", 7, "tottonham", 30));
		list.add(new FootballPlayer("이강인", 11, "tottonham", 20));
		list.add(new FootballPlayer("이재규", 15, "bresell  ", 27));
		list.add(new FootballPlayer("김진수", 17, "seoul    ", 30));
		list.add(new FootballPlayer("이강인", 11, "tottonham", 20));
		list.add(new FootballPlayer("박민규 ", 9, "Incheon  ", 25));
		list.add(new FootballPlayer("김진수", 17, "seoul    ", 30));

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}
}