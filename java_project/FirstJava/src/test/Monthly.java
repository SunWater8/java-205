package test;

public class Monthly {

	public static void main(String[] args) {
		int[] OneMon= {50,70,35,80,65,25,30,20};
		int sum=0;
		for(int i = 0;i<OneMon.length;i++) {
			sum += OneMon[i];
		}
		System.out.println(sum+",000");
	}

}
