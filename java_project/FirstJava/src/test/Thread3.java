package test;

//10초 안에 글자 입력하면 프로그램 종료
import javax.swing.JOptionPane;

//10초 세는 카운팅 클래스 필요-카운팅 하다가 멈추는 기능 넣기. 글자 입력 받는 클래스 필요-. 동작을 실행하는 메인 클래스 하나 필요.
public class Thread3 {
	public static boolean chk = false; // 왜 false이지.?

	public static void main(String[] args) {
		Counting ct = new Counting();
		InputName in = new InputName();
		ct.start();
		in.start();
	}
}

class InputName extends Thread {

	public void run() {

		String name = JOptionPane.showInputDialog("이름을 입력하세요");
		Thread3.chk = true;
		System.out.println("Hello, " + name + "!");
		/*
		 * Scanner sc = new Scanner(System.in); String name = sc.nextLine(); if (name !=
		 * null) { System.out.println("종료합니다."); } else { return; }
		 */
	}
}

class Counting extends Thread {

	@Override
	public void run() {
		for (int i = 10; i >= 0; i--) {
			if (Thread3.chk) {
				return;
			}
			System.out.println(i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("입력시간이 지나 프로그램을 종료합니다.");
		System.exit(5);
	}
}
