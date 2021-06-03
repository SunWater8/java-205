package ex.Thread0603;

public class ThreadsyncTest {
	public static void main(String[] args) {
		Increment inc = new Increment();
		
		//쓰레드 생성
		IncThread it1 = new IncThread(inc);
		IncThread it2 = new IncThread(inc);
		IncThread it3 = new IncThread(inc);
		
		it1.start();
		it2.start();
		it3.start();
		
		try {
			it1.join();
			it2.join();
			it3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class IncThread extends Thread{
	Increment inc;
	public IncThread(Increment inc) {
		this.inc=inc;
	}
	public void run() {
		for(int i=0;i<10000; i++) {
			for(int j=0;j<10000; j++) {
				inc.increment();
			}
		}
		System.out.println(inc.getNum());
	}
}

class Increment{
	int num=0;
	public synchronized void increment() {
		num++;
	}
	public int getNum() {
		return num;
	}
}

