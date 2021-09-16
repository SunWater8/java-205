package com.bitcamp.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//회원가입 한 전체 리스트 페이지를 가지고 오는 기능.
//실제 처리하는 것은 open project이고, 회원의 전체 리스트를 출력하는 것은 rest api를 이용하여 이 프로젝트에서 할 수 있게 된 것이다.
//즉, 다른 서버를 연결한 형태이다.
@Controller
public class MemberController {

	@RequestMapping("/member")
	public String page() {
		return "member";
	}
}
