package util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieBox {
	//request 객체를 이용해서 모든 Cookie 객체를 Map에 저장
	// map 저장 방식 : map<k,v> -> <쿠키이름, 쿠키객체>
	//외부에서 보지 못하도록 캡슐화
	private Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
	
	//생성자를 이용해서 Map 에 저장할 데이터 초기화하기
	//생성자를 request로 초기화 하면 모든 쿠키 객체를 가져올 수 있게 한다.
	public CookieBox(HttpServletRequest request) {
		//쿠키 타입의 배열에 쿠키를 저장하도록 하기.
		Cookie[] cookies = request.getCookies();
		//쿠키가 존재할 때 반복해서 쿠키 객체를 map에 저장하는 조건식.
		if(cookies != null && cookies.length>0) {
			for(int i=0; i<cookies.length;i++) {
				//cookieMap에 쿠키 정보 저장 (요소, 객체)
				// - map이기 때문에 key,value 쌍으로 된 형식으로 정보를 저장해 주어야 한다.
				cookieMap.put(cookies[i].getName(), cookies[i]);
			}
		}
	}
	
	//객체 생성-> 쿠키 검색(존재유무), 쿠키 이름으로 쿠키 캑체 반환, 쿠키 이름으로 쿠키 값을 반환
	
	//쿠키 이름으로 쿠키 객체를 반환하는 메소드
	public Cookie getCookie(String name) {
		//전달받은 이름의 객체가 있는지 확인(반환)
		//map의 특징 : key 값으로 get메소드 했을 때 값이 없으면  null을 반환한다.
		return cookieMap.get(name); //get() 의 인자는 찾으려는 검색어
	}
	//쿠키 이름으로 내가 찾고자 하는 쿠키가 존재하는지 확인하는 메소드
	public boolean exists(String name) { 
		// 존재하는 지 여부를 묻고 null이 아니면 true 로 반환, null이면 false 반환
		return cookieMap.get(name) != null;
		
	}
	
	//쿠키 이름으로 쿠키의 값을 반환하는 메소드
	public String getValue(String name) throws UnsupportedEncodingException {
		//쿠키 객체를 가져오기
		Cookie c = cookieMap.get(name);
		//쿠키 객체가 null이면 null을 반환, null이 아니면 값을 반환
		if(c == null) { 
			return null;
		}
		return URLDecoder.decode(c.getValue(), "utf=8");
	}
	//Cookie 객체 생성하는 메소드 : 오버로딩, static(필요할 떄 바로 만들어서 쓸 수 있도록 하기)
	//쿠키 이름, 쿠키 값
	public static Cookie makeCookie(String name, String value) throws UnsupportedEncodingException {
		
		Cookie c = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		//예외 발생 -> utf-8 을 입력하는 자리에 다른 알 수 없는 형식의 인코딩을 넣으면 예외가 발생할 수 있음 (unsupported Encoding exception)
		return c;
	}
	
	//쿠키 이름, 쿠키 값, 경로, 유지시간
	public static Cookie makeCookie(String name, String value, String path, int maxAge) throws UnsupportedEncodingException {
		Cookie c = new Cookie(name, URLEncoder.encode(value, "utf-8"));//예외 발생
		c.setPath(path); //  / (슬래시를 default로 설정)
		c.setMaxAge(maxAge);
		return c;
	}
	//쿠키 이름, 쿠키 값, 경로, 유지시간, 도메인
	public static Cookie makeCookie(String name, String value, String path, int maxAge, String domain) throws UnsupportedEncodingException {
		Cookie c = new Cookie(name, URLEncoder.encode(value, "utf-8"));//예외 발생
		c.setPath(path); //  /(슬래시) 설정
		c.setMaxAge(maxAge);
		c.setDomain(domain); 
		return c;
	}
	
}
