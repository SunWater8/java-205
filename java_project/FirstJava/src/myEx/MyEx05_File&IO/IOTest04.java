//FileWriterStream

package test;

import java.io.*;

public class IOTest04 {
	public static void main(String[] args) {
		try {
			System.out.println("문자 스트림 파일 생성");
			Writer out = new FileWriter("newFile.txt");
			
			out.write('a');
			out.write("bcd");
			String str = "efg";
			out.write(str);
			out.close();
			System.out.println("문자 스트림 종료");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
