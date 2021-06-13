// 호스트 이름과 (도메인 네임) ip 주소 출력하기

package ex.Network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) {
		
		String urlStr="www.naver.com";
		try { 
			InetAddress ip = InetAddress.getByName(urlStr);
			System.out.println("호스트 이름 : "+ ip.getHostName());
			System.out.println("IP Address : "+ip.getHostAddress());
			
		} catch (UnknownHostException e) { //도메인 주소에 오타가 있거나 서버가 불완전 할 때 발생할 예외를 염두해두기 위한 try catch 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
