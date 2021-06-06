package test;
import javax.swing.JOptionPane;

public class Thread3Test {
	
	/*6. 변수 하나를 만든다.countDown을 확인하려는 목적으로 만들었고 다른 Thread 의 스택영역에서 
	공유되는 static 변수이다. 다행히 이 변수를 제어하는 Thread가 하나여서(InputThread 클래스에서 
			true 로 바꾸며 제어 함.) 충돌이 나지 않아 동기화 문제가 발생하지는 않았다.*/
	public static boolean chk = false;
	
	public static void main(String[] args) {

		// 3. 카운트 하는 클래스 인스턴스 생성해서 thread 실행하기
		// 5. 팝업 창 나오게 하는 클래스를 인스턴스 생성해서 Thread 실행하기
		CountDownThread ct = new CountDownThread();
		InputThread it = new InputThread();
		ct.start();
		it.start();
	}
}

//4. ﻿팝업창을 위한 클래스 따로 만들기 (Thread 목적)
class InputThread extends Thread {
	@Override
	public void run() {
		String name = JOptionPane.showInputDialog("이름을 입력해 주세요.");
		/*8. 이 문장을 수행한다는 것은 위의 문장을 완료 했다는 것. 즉, 팝업창에 뭔가를 입력 했다는 의미. 
		 이 때 chk를 true로 바꾸도록 하는 구문을 만들고 다음 문장을 출력하도록 한다. 
		 입력을 하게 되면 더이상 카운트다운 하지 않게 된다.*/
		Thread3Test.chk=true;
		System.out.println("안녕하세요. " + name + "입니다.");
	}
}
//2. 카운트하는 클래스 만들기 (thread 목적)
class CountDownThread extends Thread {
	@Override
	public void run() {
		for(int i = 9; i > 0; i--) {
			/*7. chk가 true라면 return 해주자는 의미 (return : 이 run메소드를 종료해주자는 뜻). 
			하지만 chk가 여전히 false라고 하면은 그냥 if문을 빠져나와서(if문 무시) 다음 문장을 실행하도록 한다.*/
			if(Thread3Test.chk) {
				return;
			}
			System.out.println(i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//9. 카운트 다운이 끝나면 다음 문장을 출력하도록 한다.
		System.out.println("입력시간이 지나 프로그램을 종료합니다.");
		//10. 이건 뭔뜻인지 아직도 모르겠음....
		System.exit(0);
	}
}