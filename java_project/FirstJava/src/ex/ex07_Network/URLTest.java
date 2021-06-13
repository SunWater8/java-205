package ex.Network;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {

	public static void main(String[] args) {
		String urlStr = "https://news.naver.com/main/read.nhn?mode=LSD&mid=sec&sid1=001&oid=021&aid=0002473527";
		
		//url 객체 만들어 보기
		try {
			URL url = new URL(urlStr);
			
		System.out.println("Protocol         : " + url.getProtocol());
		System.out.println("Host Name        : "+url.getHost());
		System.out.println("Port Num         : "+url.getPort());
		System.out.println("Default Port Num : "+url.getDefaultPort());
		System.out.println("Query            : "+ url.getQuery());
		System.out.println("Path             : " + url.getPath());
		System.out.println("File             : "+ url.getFile());
			
		} catch (MalformedURLException e) {//url 객체 만들 때 규격에 맞는 문자열이 아닐 때 예외가 발생한다.
			e.printStackTrace();
		}
	}
	

}
