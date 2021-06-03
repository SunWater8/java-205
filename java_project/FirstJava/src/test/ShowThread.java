package test;

public class ShowThread extends Thread{
	
	String name;
	public ShowThread(String name) {
		this.name = name;
	}
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("Hello, This is "+name);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	


	public static void main(String[] args) {
		ShowThread st1=new ShowThread("Thread1");
		ShowThread st2=new ShowThread("Second Thread2");
		ShowThread st3=new ShowThread("Third Thread3");
		
		st1.start();
		st2.start();
		st3.start();
	}
}
