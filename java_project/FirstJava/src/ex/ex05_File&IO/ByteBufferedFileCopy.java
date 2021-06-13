package ex.FileIOStream0602;

import java.io.*;

public class ByteBufferedFileCopy {
	public static void main(String[] args) {
		try {
			InputStream in = new FileInputStream("origin.pdf");
			OutputStream out = new FileOutputStream("copy3.pdf");
			
			//필터 스트림 생성하기 (기본 스트림 필요)
			BufferedInputStream fin = new BufferedInputStream(in);
			BufferedOutputStream bout = new BufferedOutputStream(out);
			int copyByte=0;
			int bData;
			
			while(true) {
				bData=fin.read();
				if(bData == -1) {
					break;
				}
				bout.write(bData);
				copyByte++;
			}
			fin.close();
			bout.close();
			System.out.println("복사된 바이트 크기 : "+copyByte+"byte");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
