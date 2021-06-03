package ch12;

import java.io.*;

public class MakeNote {
	public static void main(String[] args) {
		
		//① File 클래스를 이용해서 저장 폴더 생성
		File newDir = new File("C:\\myJava");
		if(!newDir.exists()) {
			newDir.mkdir();
			return;
		}
		
		//② 문자기반 스트림을 이용해서 날짜와 제목, 메모를 파일에 저장
		//③ 파일의 이름은 날짜와 메모의 제목을 이용해서 생성
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("C:\\myJava\\210603준비물.txt"));
			
			System.out.println("입력 시작");
			out.write("날짜 : 2021년 6월 3일");
			out.newLine();
			out.write("제목 : Memo");
			out.newLine();
			out.write("** 준비물**");
			out.newLine();
			out.write("초콜릿");
			out.newLine();
			out.write("손수건");
			out.newLine();
			out.write("생수");
			out.close();
			System.out.println("입력 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
