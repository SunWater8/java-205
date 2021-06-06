package test;

public class ThreadTest1 {
	public static void main(String[] args) {

		ThreadClass tc1 = new ThreadClass("보라돌이");
		ThreadClass tc2 = new ThreadClass("★나나★");
		
		tc1.start();
		tc2.start();
	}
}

class ThreadClass extends Thread {
	String name;

	public ThreadClass(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("안녕하세요. 저는 " + name + "입니다.");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}