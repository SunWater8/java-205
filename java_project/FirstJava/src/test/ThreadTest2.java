package test;
class Sum{
	int num;
	public void add(int n) {
		num += n;
	}
	public int getNum() {
		return num;
	}
}
class AdderThread extends Sum implements Runnable{
	int start;
	int end;
	
	public AdderThread(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		for(int i =start;i<=end;i++) {
			add(i);
		}
	}
	
}
public class ThreadTest2{
	public static void main(String[] args) {
		AdderThread at1 = new AdderThread(1, 50);
		AdderThread at2 = new AdderThread(51, 100);
		
		Thread tr1 = new Thread(at1);
		Thread tr2 = new Thread(at2);
		
		tr1.start();
		tr2.start();
		
		try {
			tr1.join();
			tr2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(at1.getNum()+at2.getNum());
	}
}
