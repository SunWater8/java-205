package util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieBox {

	private Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
	public CookieBox(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null && cookies.length>0) {
			for(int i=-0; i<cookies.length; i++) {
				cookieMap.put(cookies[i].getName(), cookies[i]);
			}
		}
	}
	
	public static Cookie makeCookie(String name, String value) {
		return new Cookie(name, value);
	}
	public static Cookie makeCookie(String name, String value, String path, int maxAge) {
		Cookie c = new Cookie(name, value);
		c.setPath(path);
		c.setMaxAge(maxAge);
		return c;
	}
	
	
}
