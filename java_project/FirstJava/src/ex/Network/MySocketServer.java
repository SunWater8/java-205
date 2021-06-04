package ex.Network;

import java.io.*;
import java.net.*;

public class MySocketServer {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(9999);
			System.out.println("서버 실행!");
			//Socket에서 client의 요청이 있을 때 까지 socket 객체에서 대기하고 있도록 하기
			Socket s = ss.accept();
			
			if(s != null) {
				System.out.println("client의 접속 요청 : socket 생성");
			}
			
			//서버는 client 가 보낸 데이터 받기
			DataInputStream dis = new DataInputStream(s.getInputStream());
			String str = (String)dis.readUTF();
			System.out.println("message= "+str);
			
			dis.close();
			ss.close();
			
			
		} catch (IOException e) {
			System.out.println(e);
//			e.printStackTrace();
		}
	}

}
