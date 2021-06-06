package test;
import java.io.*;

public class IOTest02 {
	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;
		
		try {
			in = new FileInputStream("orgin.pdf");
			out = new FileOutputStream("copy2.pdf");
			
			int copyByte = 0;
			byte[] buf = new byte[1024];
			int readLen;
			
			while(true) {
				readLen = in.read(buf);
				if(readLen == -1) {
					break;
				}
				out.write(buf, 0, readLen);
				copyByte += readLen;
			}
			in.close();
			out.close();
			
			System.out.println("파일의 크기 : "+copyByte+"byte");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
