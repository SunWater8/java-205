package ch06;

public class StudentMain {
	
	public static void main(String[] args) {
		Student[] students = new Student[10];

		students[0] = new Student("홍길동",65,98,87);
		students[1] = new Student("정지수",85,45,97);
		students[2] = new Student("고길동",88,75,98);
		students[3] = new Student("둘리몬",25,33,64);
		students[4] = new Student("포켓몬",78,94,82);
		students[5] = new Student("스터몬",54,76,84);
		students[6] = new Student("이순신",27,54,68);
		students[7] = new Student("계백몬",85,95,87);
		students[8] = new Student("이창준",95,84,45);
		students[9] = new Student("지수현",67,68,75);

		
		System.out.println("이름 \t국어 \t영어 \t수학 \t총점 \t평균");
		System.out.println("=================================================");
		for(int i=0; i<students.length;i++) {

			System.out.println(students[i].getName()+"\t"+students[i].getKorTest()+"\t"+students[i].getEngTest()+"\t"+students[i].getMathTest()+"\t"+students[i].total()+"\t"+students[i].avg());
			
		}

	}

}
