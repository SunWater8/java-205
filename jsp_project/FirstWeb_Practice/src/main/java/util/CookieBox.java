package util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieBox {

	public Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
	
	//생성자
	public CookieBox(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null && cookies.length>0) {  
			for(int i=0; i<cookies.length;i++) {
				cookieMap.put(cookies[i].getName(), cookies[i]);
			}
		}
	}
	
	//쿠키 이름을 가지고 검색하고, 값을 가져오고, 객체를 반환하는 메소드
	public boolean exist(String name) {
		return cookieMap.get(name) != null;
	}
	public String getValue(String name) throws UnsupportedEncodingException {
		Cookie c = cookieMap.get(name);
		if(c == null) {
			return null;
		}
		return URLDecoder.decode(c.getValue(), "utf-8");
	}
	public Cookie getCookie(String name) {
		return cookieMap.get(name);
		
	}
	
	
	//Cookie 객체를 반환하는 메소드 오버로딩 하기-역할: 쿠키 만들기
	public static Cookie makeCookie(String name, String value) throws UnsupportedEncodingException {
		Cookie c = new Cookie(name,URLEncoder.encode(value, "utf-8"));
		return c;
	}
	public static Cookie makeCookie(String name, String value, String path, int maxAge ) throws UnsupportedEncodingException {
		Cookie c = new Cookie(name,URLEncoder.encode(value, "utf-8"));
		c.setPath(path);
		c.setMaxAge(maxAge);
		return c;
	}
	public static Cookie makeCookie(String name, String value, String path, int maxAge , String domain) throws UnsupportedEncodingException {
		Cookie c = new Cookie(name,URLEncoder.encode(value, "utf-8"));
		c.setPath(domain);
		c.setMaxAge(maxAge);
		c.setDomain(domain);
		return c;
	}
	
}
