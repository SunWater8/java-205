package filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
/**
 * Servlet Filter implementation class CharacterEncodingFilter
 */
@WebFilter(
		//request : 사용자로부터 직접 전달되는 request, default
		dispatcherTypes = {DispatcherType.REQUEST }
					, 
		//filtering 대상의 url 목록들			
		urlPatterns = { 
				"/*", 
				"/request/*"
		}, 
		//initParams : 초기 값 설정시 사용된다. 
		initParams = { 
				@WebInitParam(name = "encoding", value = "utf-8")
		})
public class CharacterEncodingFilter implements Filter {
	
    private String encoding;
    
    public void CharacterEncoding() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		httpRequest.setCharacterEncoding(encoding);

		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		String paramValue = fConfig.getInitParameter("encoding");
		
		//문자set을 바꿔야할 경우 데이터가 없다면 utf 8로 인코딩, 없다면 paramvalue로 인코딩 해주도록 한다.
		if(paramValue != null) {
			this.encoding = "utf-8";
		}else {
			this.encoding = paramValue;
		}
	}

}
