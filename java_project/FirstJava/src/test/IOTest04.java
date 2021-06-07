package test;
import java.io.*;

public class IOTest04 {

	public static void main(String[] args) {
		try {
			//바이트 스트림에서는 1바이트 씩 읽고 쓰기가 가능했지만 문자 스트림에서는 2바이트 씩 읽고 쓰기를 하게 된다.
			
			System.out.println("문자스트림 생성");
			
			Writer out = new FileWriter("memo.txt");
			
			out.write('A');
			out.write('B');
			char ch1 = 'C';
			out.write(ch1);
			out.write("DE");
			
			out.close();
			System.out.println("파일 생성 완료");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
