package test;
import java.util.*;

public class WebAccount {
	private String name;
	private String id;
	private String birthday;
	private int age;
	private String job;
	private int nationalNum;
	
	WebAccount(String name, String id, String birthday, int age, String job, int nationalNum){
		this.name=name;
		this.id=id;
		this.birthday=birthday;
		this.age=age;
		this.job=job;
		this.nationalNum=nationalNum;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public int getNationalNum() {
		return nationalNum;
	}


	public void setNationalNum(int nationalNum) {
		this.nationalNum = nationalNum;
	}


	@Override
	public String toString() {
		return "WebAccount [name=" + name + ", id=" + id + ", birthday=" + birthday + ", age=" + age + ", job=" + job
				+ ", nationalNum=" + nationalNum + "]";
	}


	public static void main(String[] args) {
		List<WebAccount> account = new ArrayList<>();
		account.add(new WebAccount("Sam", "cloudnine", "4월 21일", 45, "bank seller", 80));
		account.add(new WebAccount("Sam", "nain", "4월 21일", 45, "bank seller", 80));
		account.add(new WebAccount("Micky", "mouse", "4월 28일", 15, "Student", 82));
		account.add(new WebAccount("Micky", "mouse", "4월 28일", 15, "Student", 82));
		account.add(new WebAccount("Mule", "kale", "2월 1일", 24, "teacher", 51));
		
	}

}
