package ch05;

public class MemberMain {
	public static void main(String[] args) {
		Member member = new Member("Jamie", "010-5989-1245", "불어",1,"abcd@naver.com", "1900년 0월 0일", "서울시 마포구");
		//변수 값 setter/getter 메소드로 수정하고 출력하기
		member.setName("영희");
		member.showInfo();
		
		System.out.println();
		System.out.println(member.getName());
		
	}

}
