package test;
import java.io.*;

public class IOTest03 {
	public static void main(String[] args) {
		try {
			InputStream in = new FileInputStream("origin2.pdf");
			OutputStream out = new FileOutputStream("copy3.pdf");
			
			BufferedInputStream bin = new BufferedInputStream(in);
			BufferedOutputStream bout = new BufferedOutputStream(out);
			
			int copyByte = 0;
			int bData;
			
			while(true) {
				bData = bin.read();
				if(bData == -1) {
					break;
				}
				bout.write(bData);
				copyByte++;
			}
			bin.close();
			bout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
