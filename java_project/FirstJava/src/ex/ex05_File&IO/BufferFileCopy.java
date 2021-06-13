//1바이트가 아닌 내가 정한 바이트 수 만큼씩 파일을 복사한다.
//1바이트 복사보다 훨씬 속도가 빠르게 복사가 된다.

package ex.FileIOStream0602;
import java.io.*;

public class BufferFileCopy {
	public static void main(String[] args)throws IOException {
		InputStream in = new FileInputStream("origin.pdf");
		OutputStream out = new FileOutputStream("copy2.pdf");
		int copyByte =0;

		//파일에서 읽어 올 바이트 데이터 배열 만들기 (1kb 사이즈의 배열)
		byte[] buf=new byte[1024]; //1024byte = 1kb
		//읽어 온 데이터 배열의 개수
		int readLen=0;
		while(true) {
			readLen = in.read(buf); //완료 시점에는 -1 반환한다.
			if(readLen==-1) {
				break;
			}
			out.write(buf,0,readLen);//정상적으로 다 써줄 것이기에 0
			copyByte+= readLen;
		}
		in.close();
		out.close();
		System.out.println("복사된 바이트 크기"+copyByte);
	}
}
