package ch06;

public class ScoreManager {

	public static void main(String[] args) {
		
		int[] korScore = new int[10]; 
		
		korScore[0]=90;
		korScore[1]=56;
		korScore[2]=97;
		korScore[3]=97;
		korScore[4]=75;
		korScore[5]=68;
		korScore[6]=79;
		korScore[7]=62;
		korScore[8]=91;
		korScore[9]=83;
		
		int sum=0;
		for(int i=0; i<korScore.length;i++) {
			System.out.println(korScore[i]);
			sum += korScore[i];
		}
		System.out.println("총합 : "+sum);
		System.out.println("평균 : "+(float)sum/korScore.length);
		
	}

}
