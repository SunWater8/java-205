//txt 파일에 printf/println/print 사용해서 입력하기

package ex.FileIOStream0602;
import java.io.*;

public class PrintWriterStream {
	public static void main(String[] args) {
		try {
			PrintWriter out = new PrintWriter(new FileWriter("printf.txt"));
			
			out.printf("제 나이는 %d살 입니다.", 24);
			out.println("");
			
			out.println("저는 자바가 좋습니다.");
			out.print("특히 IO 부분에서 많은 매력을 느낍니다.");
			out.close();
			
			System.out.println("작업이 완료됨");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
