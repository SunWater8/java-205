package ch06;

public class ScoreManager {

	public static void main(String[] args) {
		int[] korTest = {80,86,94,75,85,64,54,24,78,55};
		int[] engTest = {87,85,94,65,45,75,53,61,82,94};
		int[] mathTest = {75,94,86,57,64,82,93,81,72,68};
		
		int sum1=0;
		for(int idx = 0; idx<korTest.length;idx++) {
			System.out.println(korTest[idx]);
			sum1 += korTest[idx];
		}
		
		int sum2=0;
		for(int idx = 0; idx<engTest.length;idx++) {
			System.out.println(engTest[idx]);
			sum2 += engTest[idx];
		}
		
		int sum3 = 0;
		for(int i = 0; i<mathTest.length;i++) {
			System.out.println(mathTest[i]);
			sum3 += mathTest[i];
		}
		float avg1 = (float)sum1/korTest.length;
		float avg2 = (float)sum2/engTest.length;
		float avg3 = (float)sum3/mathTest.length;
		
		
		
	}

}
