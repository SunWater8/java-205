package test;

import java.io.File;

public class IOTest12 {
	public static void main(String[] args) {
		File myFile = new File("C:\\myJava\\origin.pdf");
		System.out.println(myFile);

		if (!myFile.exists()) { 
			System.out.println("원본 파일이 준비되어 있지 않습니다.");
			System.out.println("프로그램을 종료합니다.");
			return;
		}

		File newDir = new File("C:\\YourJava"); 
		System.out.println("1. exist ?? --> " + newDir.exists()); 

		if (!newDir.exists()) {
			newDir.mkdir();
			System.out.println("2. exist ?? --> " + newDir.exists());
			return;
		}
		
		File newFile = new File(newDir, myFile.getName());
		myFile.renameTo(newFile);
		
		if(newFile.exists()) { 
			System.out.println("파일 이동에 성공하였습니다.");
		}else {
			System.out.println("파일 이동에 실패하였습니다.");
		}
	}
}
