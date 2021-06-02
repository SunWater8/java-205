//txt 파일 안에 문자 써서 저장 하기.
package ex.FileIOStream0602;
import java.io.*;

public class FileWriterStream {
	public static void main(String[] args) {
		
		//문자 단위 저장을 위한 출력 스트림
		//Writer 중에서 파일에 쓰는 것이기 때문에 FileWriter 사용.
		
		try {
			System.out.println("문자스트림 생성");
			
			Writer out = new FileWriter("hyper.txt");
			char ch1 = 'A';
			char ch2 = 'B';
			String str = "CD";
			
			//쓰기
			out.write(ch1);
			out.write(ch2);
			out.write(str);
			out.write('E');
			out.write("FG");
			
			out.close();
			
			System.out.println("글쓰기 완성");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
