package test;
import java.io.*;

public class IOTest02 {
	public static void main(String[] args) {
		System.out.println("파일 복사 시작");
		try {
			InputStream in = new FileInputStream("origin.pdf");
			OutputStream out = new FileOutputStream("copy.pdf");
			
			int copyByte=0;
			byte[] buf = new byte[1024];
			int readLen;
			
			while(true) {
				readLen = in.read(buf);
				if(readLen==-1) {
					break;
				}
				out.write(buf, 0, readLen);
				copyByte += readLen;
			}
			in.close();
			out.close();
			System.out.println("파일의 용량 : "+copyByte+"바이트");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}