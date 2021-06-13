// txt파일 읽기
package ex.FileIOStream0602;
import java.io.*;
public class FileReaderStream {
	public static void main(String[] args) {
		System.out.println("읽기 시작");
		//문자 단위로 읽어 올 스트림 생성
		//Read -> FileReader
		try {
			Reader in= new FileReader("hyper.txt");
			
			//읽어 올 수 있는 문자 단위 만들기
			char[] cbuf = new char[10]; //char로 된 문자 10개씩 가져오기
			int readLen=0;
			readLen = in.read(cbuf, 0, cbuf.length); //cbuf에 담기, 제일 첫번째 문자부터 index 0 , 배열사이즈인 10개 담기
			
			//출력방식1.
			//배열에 담겨 있는 10개의 문자 읽어 오는 반복문 만들기
//			for(int i=0; i<readLen; i++) {
//				System.out.println(cbuf[i]);
//			}
			
			//출력방식2. 
//			System.out.println(new String(cbuf)); //위의 반복문을 대신해서 쓸 수 있다.
			
			//출력방식3.
			System.out.println(cbuf);
			
			in.close();
			System.out.println("읽기 완료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
