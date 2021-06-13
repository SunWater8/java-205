package ex.Thread0603;

public class ShowThreadMain {
	public static void main(String[] args) {
		//Thread Instance 생성
		ShowThread t1 = new ShowThread("Thread 1");
		ShowThread t2 = new ShowThread("        Thread 2");//차이를 두기 위해 글자 앞에 공백 만들음
		
		//thread의 실행
		t1.start();
		t2.start();
	}
}
