package test;
import java.io.*;

public class IOTest01_2 {
	public static boolean chk = false;
	public static void main(String[] args) {
		FileCopy fc = new FileCopy();
		Count count = new Count();
		count.start();
		fc.start();
	}
}
class FileCopy extends Thread {

	@Override
	public void run() {
		InputStream in = null;
		OutputStream out = null;
		try {
			System.out.println("파일 복사 시작");
			
			in = new FileInputStream("git.pdf");
			out = new FileOutputStream("copy.pdf");
			int copyByte = 0; 
			int bData = -1;

			while (true) {
				bData = in.read();
				if (bData == -1) { 
					break;
				}
				out.write(bData);
				copyByte++;
			}
			in.close();
			out.close();
			IOTest01_2.chk = true;

			System.out.println();
			System.out.println("파일 복사 완료");
			System.out.println("복사 된 바이트 크기 : " + copyByte + "byte");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Count extends Thread {
	@Override
	public void run() {
		for (int i = 1; i < 20; i++) {
			if (IOTest01_2.chk)
				return;
			System.out.println(i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
