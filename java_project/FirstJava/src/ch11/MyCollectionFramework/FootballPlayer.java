

package ch11.MyCollectionFramework;
import java.util.*;

public class FootballPlayer {

	protected String name;
	private int number;
	private String team;
	private int age;
	
	FootballPlayer(String name, int number, String team, int age){
		this.name=name;
		this.number=number;
		this.team=team;
		this.age=age;
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
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj != null && obj instanceof FootballPlayer) {
			FootballPlayer foot = (FootballPlayer) obj;
			if (this.name == foot.name) {
				if (this.number == foot.number) {
					if (age == foot.age) {
						result = true;

					}
				}
			}
		}
		return result;
	}
	public String toString() {
		return "이름:"+name+", 등번호:"+number+", 소속팀:"+team+", 나이:"+age;
	}
}
