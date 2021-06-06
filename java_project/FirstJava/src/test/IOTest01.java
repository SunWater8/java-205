package test;
import java.io.*;

public class IOTest01 {
	public static void main(String[] args) {
		try {
			InputStream in = new FileInputStream("orgin.pdf");
			OutputStream out = new FileOutputStream("copy2.pdf");
			
			int byteCopy = 0;
			int bData;
			
			while(true) {
				bData = in.read();
				if(bData == -1) {
					break;
				}
				out.write(bData);
				byteCopy++;
			}
			in.close();
			out.close();
			
			System.out.println("복사한 파일의 용량 : "+byteCopy+"byte");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
