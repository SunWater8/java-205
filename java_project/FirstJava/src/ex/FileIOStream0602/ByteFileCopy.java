//1바이트씩 이동해서 복사하기

package ex.FileIOStream0602;
import java.io.*;

public class ByteFileCopy {
	public static void main(String[] args) {
		try {
			//1. 파일을 바이너리 데이터로 읽어 올 스트림을 생성하기 : FileInputStream
			InputStream in = new FileInputStream("origin.pdf"); //다형성 적용
			//2. 파일을 쓰기 위한 스트림 생성 하기 : FileOutputStream
			OutputStream out = new FileOutputStream("copy.pdf");
			
			//카피한 데이터의 크기
			int copyByte=0;
			
			//파일에서 읽어 올 바이트 데이터
			int bData = -1;
			
			while(true) {//위에 정의 한 bData를 0으로 하고 while(false)라고 해도 됨.
				bData=in.read();
				
				//탈출의 조건 : 파일의 모든 데이터를 읽은 경우
				if(bData==-1) {
					break;
				}
				
				//(-1이 아니면) 출력 : 파일에 데이터를 쓴다.
				out.write(bData);//1바이트 쓰기
				copyByte++;
			}
			//스트림 닫기
			in.close();
			out.close();
			
			//완료된 복사파일의 사이즈 출력하기
			System.out.println("복사 완료!! 복사된 바이트 크기 : "+copyByte+"byte");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

