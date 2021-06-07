package test;
import java.io.*;

public class IOTest03 {

	public static void main(String[] args) {
		try {
			//1. FileInputStream 과 FileOutputStream 의 인스턴스 생성
			System.out.println("start to copy");
			InputStream in = new FileInputStream("origin.pdf");
			OutputStream out = new FileOutputStream("copy4filter.pdf");
			
			//2. bufferedInputStream 인스턴스 생성 - 생성자를 꼭 써준다.
			BufferedInputStream bin = new BufferedInputStream(in);
			BufferedOutputStream bout = new BufferedOutputStream(out);
			
			//3. 복사할 데이터의 바이트 단위의 역할을 할 변수 생성
			int copyByte=0;
			//4. 파일을 복사할 때 읽고 쓸 역할을 할 변수 생성
			int bData;
			
			//5. 파일 복사 동작할 반복문 만들기
			while(true) {
				//6. BufferedInputStream의 참조변수를 사용하여 read()메소드 호출하기.
				bData=bin.read();
				if(bData==-1) {
					break;
				}
				//7. write 메소드 사용할 때 BufferedOutputStream 의 참조변수 사용하기.
				bout.write(bData);
				copyByte++;
			}
			
			in.close();
			out.close(); 
			System.out.println("completed!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
