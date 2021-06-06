//1-50,51-100

package test;

public class ThreadTest2{
	public static void main (String[] args) {
		AdderThread at1 = new AdderThread(1, 50);
		AdderThread at2 = new AdderThread(51, 100);
		
		Thread th1 = new Thread(at1);
		Thread th2 = new Thread(at2);
		
		th1.start();
		th2.start();
		
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("1~100의 합 : "+(at1.getNum()+at2.getNum()));
	}
}

class Sum{
	int num;
	public void add(int a) {
		num += a;
	}
	public int getNum() {
		return num;
	}
}

class AdderThread extends Sum implements Runnable{
	int start;
	int end;
	
	public AdderThread(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		for(int i=start; i<=end;i++) {
			add(i);
		}
		
	}
	
}