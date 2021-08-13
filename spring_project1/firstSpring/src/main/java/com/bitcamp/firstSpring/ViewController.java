package com.bitcamp.firstSpring;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	@RequestMapping("/view/view1")
	public void getPage1() {}
	//view를 지정하지 않았기 때문에 404가 뜸.
	//자바코드를 간결하게 하기 위해 requestmapping 괄호에 써있는 대로 만들기도 한다.

	//반환타입이 Model일 때 뷰 지정 방법
	@RequestMapping("/view/view2")
	public Model getPage2() {
		Model model = new Model() {
			
			@Override
			public Model mergeAttributes(Map<String, ?> attributes) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean containsAttribute(String attributeName) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Map<String, Object> asMap() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Model addAttribute(String attributeName, Object attributeValue) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Model addAttribute(Object attributeValue) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Model addAllAttributes(Map<String, ?> attributes) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Model addAllAttributes(Collection<?> attributeValues) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		return model;
	}
	
	//반환타입이 map일 때 뷰 지정하는 방법
	@RequestMapping("/view/view3")
	public Map getPage3() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "COOL");
		
		return map;
	}
}
