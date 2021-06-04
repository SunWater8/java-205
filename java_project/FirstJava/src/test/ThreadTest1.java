package test;

class Ring extends Thread{
	String word;
	
	Ring(String w){
		word=w;
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.println(word);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

public class ThreadTest1 {
	public static void main(String[] args) {
		Ring r = new Ring("hello");
		Ring r2 = new Ring("      bye");
		
		r.start();
		r2.start();
		
	}
}
