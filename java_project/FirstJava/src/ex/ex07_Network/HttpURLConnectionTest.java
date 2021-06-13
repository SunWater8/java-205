package ex.Network;
import java.io.IOException;
import java.net.*;

public class HttpURLConnectionTest {

	public static void main(String[] args) {
		String urlStr = "https://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=100&oid=018&aid=0004947634";
		try {
			URL url = new URL(urlStr);
			
			//HttpURLConnection : rul.openConnection()
			HttpURLConnection hcon = (HttpURLConnection) url.openConnection();
			
			for(int i = 1; i<=8; i++) {
				System.out.println(hcon.getHeaderFieldKey(i)+" : " + hcon.getHeaderField(i));
			}
			hcon.disconnect();
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
