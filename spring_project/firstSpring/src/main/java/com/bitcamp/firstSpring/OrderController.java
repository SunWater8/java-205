package com.bitcamp.firstSpring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.firstSpring.member.domain.OrderCommand;

@Controller
@RequestMapping("/order/order")   //사용자 요청 정의
public class OrderController {

	@RequestMapping(method = RequestMethod.GET)
	public String getOrderForm() {
		return "order/orderForm";  // /WEB-INF/views/order/orderForm.jsp 이 곳을 찾아가게 됨.
	}
	
	//주소를 post 방식으로 받기
	@RequestMapping(method = RequestMethod.POST)
	public String order(
			OrderCommand orderCommand
			) {
		//list에 객체가 잘 들어갔는지 출력해보기
		System.out.println(orderCommand);
		
		return "order/order";
	}
}
