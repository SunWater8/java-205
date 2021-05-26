package ch06;

public class TestAvg {

	public static void main(String[] args) {
		int[] korTest = {80,86,94,75,85,64,54,24,78,55};
		int[] engTest = {87,85,94,65,45,75,53,61,82,94};
		int[] mathTest = {75,94,86,57,64,82,93,81,72,68};
		
		int sum1=0;
		for(int i = 0; i<korTest.length;i++) {
			sum1 += korTest[i];
		}
		float avg1 = (float)sum1/korTest.length;
		
		int sum2=0;
		for(int i = 0; i<engTest.length;i++) {
			sum2 += engTest[i];
		}
		float avg2 = (float)sum2/engTest.length;
		
		int sum3 = 0;
		for(int i = 0; i<mathTest.length;i++) {
			sum3 += mathTest[i];
		}
		float avg3 = (float)sum3/mathTest.length;
		
		System.out.println("   국어  영어  수학");
		System.out.println("=================");
		for (int i =0; i<korTest.length;i++) {
			
			System.out.println("   "+korTest[i] +"   "+ engTest[i] +"   "+ mathTest[i]);
		}
		System.out.println("=================");
		System.out.println("평균 "+avg1+" "+avg2+" "+avg3);
		
		
		
	}

}
