package ex.FileIOStream0602;

import java.io.*;

public class FileMove {
	public static void main(String[] args) {
//		File myFile = new File("C:\\myJava", "origin.pdf");
		File myFile = new File("C:\\myJava\\origin.pdf");// 위와 같은 의미
//		File myFile = new File("C:"+File.separator+"myJava"+File.separator+"origin.pdf");// 역슬래시를 File.separator라고 써주어도 된다. 리눅스와의 호환 이슈 때문이다.
		System.out.println(myFile);// 경로 출력

//		if(myFile.exists()==false) { 
		if (!myFile.exists()) { // 'myFile이 존재한하지 않는다면' //위 문장과 같은 의미
			System.out.println("원본 파일이 준비되어 있지 않습니다.");
			System.out.println("프로그램을 종료합니다.");
			return;
		}

		// 새로운 폴더를 생성하기 : 경로 생성 -> 폴더 생성
		File newDir = new File("C:\\YourJava"); // 경로 정보만 가지고 있기
		System.out.println("1. exist ?? --> " + newDir.exists()); // 폴더가 생성 되었는지 확인해보기

		// 폴더 생성
		if (!newDir.exists()) {
			newDir.mkdir();
			System.out.println("2. exist ?? --> " + newDir.exists());
			return;
		}
		
//		System.out.println(myFile.getName()); // getName메소드로 파일 이름 출력 것이 맞는지 사전에 확인해보기 
		
		//이동할 경로만 만들어 놓기
		File newFile = new File(newDir, myFile.getName());//파일 이름을 직접 쓰는 것 보다 getName()메소드를 쓰는 것이 좋음.
		
		//이동하기
		myFile.renameTo(newFile);
		
		//파일이 이동 되었는지 확인하기
		if(newFile.exists()) { 
			System.out.println("파일 이동에 성공하였습니다.");
		}else {
			System.out.println("파일 이동에 실패하였습니다.");
		}
	}
}
