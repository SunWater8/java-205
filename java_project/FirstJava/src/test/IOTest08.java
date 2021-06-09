//PrintWriterStream

package test;
import java.io.*;

public class IOTest08 {

	public static void main(String[] args) {
		try {
			PrintWriter out = new PrintWriter (new FileWriter("printWrite.txt"));
			
			out.print("정부가 특수형태 근로 종사자를");
			out.println("");
			out.println("국가 건강검진 실명 의사제를 도입하다.");
			out.printf("%d년 후에 체계를 마련할 것이다.", 2);
			out.close();
			
			System.out.println("작업이 완료");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
