package ch13;
import javax.swing.JOptionPane;

public class Game {
	static boolean check = false;
	public static void main(String[] args) {
		Counting ct = new Counting();
		Input in = new Input();
		
		ct.start();
		in.start();
	}
}

class Input extends Thread {
	public void run() {
		int gess = (int) (Math.random() * 100);
		System.out.println("1~100 사이의 숫자 맞추기 게임");
		while (true) {
			String input = JOptionPane.showInputDialog("숫자를 입력해 주세요.");
			int number = Integer.parseInt(input);
			if (number <= 100 && number > 0) {
				if (gess < number) {
					System.out.println("더 작은 숫자 입니다.");
				}else if(gess>number){
					System.out.println("더 큰 숫자 입니다.");
				}else{
					Game.check=true;
					System.out.println("정답입니다. 게임을 종료합니다.");
				}
			}else {
				System.out.println("1~100 범위 안의 숫자를 입력해 주세요.");
				
			}
		}
	}
}

class Counting extends Thread {
	public void run() {
		for(int i=10;i>=0;i--) {
			if(Game.check) {
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
		System.exit(0);
	}
}