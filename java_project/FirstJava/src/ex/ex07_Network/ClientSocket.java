package ex.Network;

import java.io.*;
import java.net.*;

public class ClientSocket {
	public static void main(String[] args) {
		try {
			//SocketServer의 IP와 Port 번호로 연결 신청하기 : socket 객체를 생성
			Socket s = new Socket("localhost", 9999);
			
			if(s != null) {
				System.out.println("서버 접속 완료");
			}
			
			//서버쪽 소켓으로 데이터 보내기
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			
			dout.writeUTF("안녕하세요~ Client에서 보내는 메시지 입니다.");
			//보낸 메시지 비우기. 버퍼 지우기
			dout.flush();
			//연결 끊기. stream삭제
			dout.close();
			//소켓 닫기
			s.close();
			
		} catch (IOException e) {
			System.out.println(e);
//			e.printStackTrace();
		}
		
	}
}
