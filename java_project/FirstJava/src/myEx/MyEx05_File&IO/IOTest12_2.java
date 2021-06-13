package test;

import java.io.File;

public class IOTest12_2 {
	public static void main(String[] args) {
		File myFile= new File("C:\\Users\\bitcamp\\Documents\\originGit.pdf");
		System.out.println(myFile);
		
		if(!myFile.exists()) {//만약  originGit 파일이 있지 않다면?
			System.out.println("원본 파일이 없습니다. 프로그램을 종료합니다.");
			return;
		}
		File newDir = new File("C:\\Users\\bitcamp\\Desktop\\newFolder"); 
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
