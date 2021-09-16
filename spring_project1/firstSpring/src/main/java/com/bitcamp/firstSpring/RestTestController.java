package com.bitcamp.firstSpring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/simple")
public class RestTestController {

	@RequestMapping(method=RequestMethod.GET)
	public String getForm() {
		return "rest/form";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody 			// @ResponseBody: 일반 문자열로 받으면 문자열로 반환해(응답해) 준다.
	public String simple(	//반환타입이 String이 아닌 Member 객체라면 어째든 반환되는 것이 json으로(문자열) 바뀌게 된다.
			@RequestBody String body
			) { 
		// ---- @RequestBody 특징 -----
		//  1. 문자열로 된 사용자의 요청 전체를 text로 받는다. (post방식일 경우)
		//  2. 받아 올 때 name = cool & age = 11 이런 url의 형식으로 갖고 옴. 
		//  3. 주로 JSON 데이터를 받을 때 @RequestBody를 이용한다. (거꾸로 말해, JSON을 사용하고자 할 때 @RequestBody를 사용함)
		//  4. JSON 을 이용할 때 GSON 라이브러리가 사용됨. GSON : 들어오는 JSON 문자열을 -> Java Object 자바의 객체로 바꾸어 줌.(타입을 변경해 줌.)
		System.out.println("body : "+body);
		
		//return null;							//@RequestBody는 사용하지만 @ResponseBody를 사용하지 않을 경우 : view에 대한 경로를 반환. return이 null일 경우 위에서 미리 정해놓았던 경로를 따라 감.
		//return "@ResponseBody를 이용한 응답";		//@RequestBody와 @ResponseBody 둘 다 사용할 경우1 : return자리에  view를 반환하는 것이 아니라 반환하려는 것 자체를 반환. 화면에는 '@ResponseBody ? ??? ??' 라고 뜸.
		return body; 							//@RequestBody와 @ResponseBody 둘 다 사용할 경우2 : 전달받은 body의 값을 그대로 텍스트로 반환하게 된다.
	}
	
}
