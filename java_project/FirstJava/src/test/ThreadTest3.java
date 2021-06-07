package test;
import javax.swing.JOptionPane;

public class ThreadTest3{
	public static boolean check = false;
	
	public static void main(String[] args) {
		Counting ct = new Counting();
		Input in = new Input();
		
		ct.start();
		in.start();
	}
}

class Input extends Thread{
	@Override
	public void run() {
		String name = JOptionPane.showInputDialog("이름을 입력해 주세요");
		ThreadTest3.check=true;
		System.out.println("안녕하세요. "+name+"님");
	}
}

class Counting extends Thread{

	@Override
	public void run() {
		for(int i=10; i>=0;i--) {
			if(ThreadTest3.check) {
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
		System.out.println("입력 시간이 초과되었습니다. 프로그램을 종료합니다.");
		System.exit(0);
		
	}
}
