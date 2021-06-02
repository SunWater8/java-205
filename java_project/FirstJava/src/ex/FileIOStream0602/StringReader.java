//txt 파일 내용을 console에 출력해보기- 문자열 줄 단위로 읽어오기(줄 단위 : 개행되기 전 까지) 

package ex.FileIOStream0602;

import java.io.*;

public class StringReader {

	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(new FileReader("String.txt"));
			//String의 str는 임시변수
			String str = null;
			while (true) {
				str = in.readLine();
				if (str == null) { //더 이상 불러올 개행이 없다면 참.
					break;
				}
				System.out.println(str);
			}
			in.close();
			System.out.println("작업이 완료되었습니다.");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
