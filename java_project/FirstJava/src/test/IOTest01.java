//ByteFileCopy

package test;
import java.io.*;

public class IOTest01 {
	public static void main(String[] args) {
		try {
			InputStream in = new FileInputStream("origin.pdf");
			OutputStream out =new FileOutputStream("copy.pdf");
			
			int copyByte=0;
			int bData;
			
			while(true) {
				bData = in.read();
				if(bData==-1) {
					break;
				}
				out.write(bData);
				copyByte++;
			}
				
			in.close();
			out.close();
			
			System.out.println("파일 복사 완료.");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
