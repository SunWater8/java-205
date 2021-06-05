package test;

class Sample extends Thread{
	String say;
	Sample(String say){
		this.say=say;
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.println(say);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

public class ThreadTest1{
	public static void main(String[] args) {
		Sample s = new Sample("Hello");
		Sample s2 = new Sample("     there");
		
		s.start();
		s2.start();
	}
}