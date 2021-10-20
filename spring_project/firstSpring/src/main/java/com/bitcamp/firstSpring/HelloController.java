package com.bitcamp.firstSpring;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	// 사용자 요청 uri 와 실행 메소드 정의 하기 : view와 결과 데이터
	@RequestMapping("/hello")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();

		// view 설정
		mav.setViewName("hello"); // /WEB-INF/views/hello.jsp 이 경로를 만들어 줌.

		// 결과 데이터 model을 저장(view 페이지에 전달)
		mav.addObject("greeting", greeting());

		return mav;
	}

	private Object greeting() {
		String str = "안녕하세요";
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

		// 6시에서 10시 사이에 아침인사 하기. 12시부터 3시 사이에 점심인사하기
		if (hour >= 6 && hour <= 10) {
			str = "좋은 아침입니다.";
		} else if (hour >= 12 && hour <= 15) {
			str = "점심식사는 하셨나요?.";
		} else if(hour>18 && hour<=22){
			System.out.println("좋은 밤 되세요");
		}
		return str;
	}
}
