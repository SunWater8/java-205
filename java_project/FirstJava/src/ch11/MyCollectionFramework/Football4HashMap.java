package ch11.MyCollectionFramework;
import java.util.*;
public class Football4HashMap {
	public static void main(String[] args) {
		HashMap<Integer, FootballPlayer> map = new HashMap<>();
		
		map.put(7, new FootballPlayer("손흥민 ", 7, "tottonham", 30));
		map.put(11, new FootballPlayer("이강인", 11, "tottonham", 20));
		map.put(15, new FootballPlayer("이재규", 15, "bresell  ", 27));
		map.put(17, new FootballPlayer("김진수", 17, "seoul    ", 30));
		map.put(11, new FootballPlayer("이강인", 11, "tottonham", 20));
		map.put(9, new FootballPlayer("박민규 ", 9, "Incheon  ", 25));
		map.put(17, new FootballPlayer("김진수", 17, "seoul    ", 30));

		System.out.println(map.get(30));
		System.out.println(map.get(20));
		System.out.println(map.get(27));
		System.out.println(map.get(25));
		System.out.println(map.get(30));
}
}