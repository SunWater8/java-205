package test;

import java.io.*;

public class CopyPdf {
	public static void main(String[] args) {
		try {
			InputStream in = new FileInputStream("orgin.pdf");
			OutputStream out = new FileOutputStream("copy.pdf");

			int byteCopy = 0;
			int bData = -1;

			while (true) {
				bData = in.read();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}