package ex.FileIOStream0602;

import java.io.File;

public class ListFileDirectoryInfo {
	public static void main(String[] args) {
		File myDir = new File("MyDir");
		File[] list = myDir.listFiles();
		
		for(int i=0; i<list.length;i++) {
			System.out.println(list[i].getName());
			if(list[i].isDirectory()) {
				System.out.println("\t\tDIR");
			}else {
				System.out.println("\t\tFILE");
			}
		}
	}
}
