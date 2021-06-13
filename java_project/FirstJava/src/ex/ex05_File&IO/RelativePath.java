package ex.FileIOStream0602;

import java.io.File;

public class RelativePath {
	public static void main(String[] args) {
		File curDir = new File("AAA");
		System.out.println(curDir.getAbsolutePath());
		
		File upperDir = new File("AAA"+File.separator+"BBB");
		System.out.println(upperDir.getAbsolutePath());
	}
}
