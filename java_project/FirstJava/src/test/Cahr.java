package test;

public class Cahr {
	public static void main(String[] args) {
		
		//2번째 글자 뽑아내기.
		String msg = "Hello, nice to meet you";
		char c = msg.charAt(1); //2번째 글자 뽑아내기
		System.out.println(c);
		
		String msg1 = "abcdefgABCD";
		char c2 = msg1.charAt(0);//1번째 글자 뽑아내기
		System.out.println(c2);
		
		//7번째 글자인 알파벳 A의 아스키코드
		char c3 = msg1.charAt(7);
		int n = (int)c3;
		System.out.println(n);
		
		System.out.println("---------------");
		String msg2 = " Nice to meet you ";
		System.out.println("length(): "+msg2.length());//길이 - 앞 뒤의 빈칸은 제외해서 셈
		System.out.println("trim(): "+msg2.trim()); //앞 뒤 빈 공간 없애기
		System.out.println("trim.length(): "+msg2.trim().length());//빈 공간 없앤 뒤 글자 갯수
		System.out.println("startsWith(): "+msg1.startsWith("ab"));//ab로 시작하는 글자 인지(?) true/false
		System.out.println("---------------");
		
		int n2 = 1234;//숫자를 문자로 전환
		String temp2 = String.valueOf(n2);
		System.out.println(temp2+2);
		
		
		//글자 바꾸기
		String msg3 = "ababc";
		String msg4 = msg3.replace("b", "c");//모든 b를 c로 바꾸기
		System.out.println(msg4);
		
		//전화번호부에서 숫자 검색하기
		String tel = "010-123-1234";
		System.out.println(tel.substring(0,2)); //01          //1번째 번호에서 2번째 번호까지 뽑아내기
		System.out.println(tel.substring(4,7)); //123         // 5번째 번호에서 7번번번째 번호까지 뽑아내기
		System.out.println(tel.substring(3));   //-123-1234   // 3번째 번호부터 출력
		
		//리터럴 문자형 받음
		char c4 = "nice to meet you".charAt(0);//문자를 바로 써도 된다.
		System.out.println(c4);
	}

}
