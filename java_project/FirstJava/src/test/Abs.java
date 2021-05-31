package test;
abstract class player {
	int currentPos;
	
	player(){
		currentPos=0;
	}
	
	abstract void play(int pos);
	abstract void stop();
	
	void play() {
		play(currentPos);
	}
}
public class Abs {
	public static void main(String[] args) {

	}
}
