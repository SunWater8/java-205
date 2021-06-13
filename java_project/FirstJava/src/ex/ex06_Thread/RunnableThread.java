package ex.Thread0603;

public class RunnableThread {
	public static void main(String[] args) {
		//Runnable 타입의 인스턴스를 생성하기
		AdderThread at1 = new AdderThread(1, 50);
		AdderThread at2 = new AdderThread(51, 100);
		
		//Thread 인스턴스 생성하기
		//new Thread(Runnable target)
		Thread t1 = new Thread(at1);
		Thread t2 = new Thread(at2);
		
		//start() 메소드를 가지고 Thread 실행하기
		t1.start();
		t2.start();
		
		System.out.println("1~100까지의 숫자 합 : "+(at1.getNum() + at2.getNum()));
		//덧셈을 하기 전에 메인 메소드가 끝나면서 결과 값은 0이 나오게 된다.
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("1~100까지의 숫자 합 : "+(at1.getNum() + at2.getNum()));
	}
}

class Sum {
	int num;

	public void addNum(int n) {
		num += n;
	}

	public int getNum() {
		return num;
	}
}

class AdderThread extends Sum implements Runnable {
	int startNum;
	int endNum;

	AdderThread(int n1, int n2) {
		this.startNum = n1;
		this.endNum = n2;
	}

	@Override
	public void run() {
		for (int i = startNum; i <= endNum; i++) {
			addNum(i);
		}
	}

}