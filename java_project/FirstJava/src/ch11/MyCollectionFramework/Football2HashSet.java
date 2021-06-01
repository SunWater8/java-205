package ch11.MyCollectionFramework;

import java.util.*;

public class Football2HashSet {
	public static void main(String[] args) {
		HashSet<FootballPlayer> hashSet = new HashSet<FootballPlayer>();

		hashSet.add(new FootballPlayer("손흥민 ", 7, "tottonham", 30));
		hashSet.add(new FootballPlayer("이강인", 11, "tottonham", 20));
		hashSet.add(new FootballPlayer("이재규", 15, "bresell  ", 27));
		hashSet.add(new FootballPlayer("김진수", 17, "seoul    ", 30));
		hashSet.add(new FootballPlayer("이강인", 11, "tottonham", 20));
		hashSet.add(new FootballPlayer("박민규 ", 9, "Incheon  ", 25));
		hashSet.add(new FootballPlayer("김진수", 17, "seoul    ", 30));

		Iterator<FootballPlayer> itr = hashSet.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
