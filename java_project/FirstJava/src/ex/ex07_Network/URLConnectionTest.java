package ex.Network;
import java.io.*;
import java.net.*;

public class URLConnectionTest {
	public static void main(String[] args) {
		try {
			URL url = new URL("www.google.com"); //www.google.com 이라고 도메인네임을 창에 입력하면 www.google.com/index.html 이라는 특정 위치로 찾아가 달라는 의미가 담겨 있다.
			
			//RULConnection 받아 오기 위해  url.openConnection() 메소드 이용하기
			URLConnection con = url.openConnection(); //내 프로그램이 파일과 연결되는 스트림이 발생함.
			InputStream in = con.getInputStream();
			
			int i=0;
			while(true) {
				i=in.read();
				if(i == -1) {
					break;
				}
				System.out.print((char)i);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
