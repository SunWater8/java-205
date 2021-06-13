package ex.Network;

import java.io.*;
import java.net.*;
import java.util.*;

public class MessageServer {
	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket s = null;

		DataInputStream din = null;
		DataOutputStream dout = null;

		try {
			ss = new ServerSocket(8888);
			System.out.println("서버 실행");
			System.out.println("==================");
			s = ss.accept();
			System.out.println("소켓 받음");
			System.out.println("==================");
			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());

			Scanner sc = new Scanner(System.in);

			String str1 = "";// 받는 변수
			String str2 = "";// 보내는 변수

			while (!str2.equals("exit")) {
				str1 = din.readUTF();
				System.out.println("client message:" + str1);
				str1 = sc.nextLine();
				dout.writeUTF(str2);
//				dout.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			Util.close(din);
			Util.close(dout);
			Util.close(ss);
			Util.close(s);
/*
			if (dout != null) {
				try {
					dout.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (din != null) {
				try {
					din.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (s != null) {
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}*/

		}

	}
}
