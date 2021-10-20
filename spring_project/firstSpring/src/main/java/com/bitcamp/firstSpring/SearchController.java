package com.bitcamp.firstSpring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.firstSpring.domain.SearchType;

@Controller
public class SearchController {
	
	@RequestMapping("/search/search")
	public String search() {
		return "search/search";
	}
	
	//@RequestMapping을 사용하고 있기 때문에 밑에 있는 ModelAttribute를 이 메소드도 공유할 수 있다.
	//일반적으로 처리해야 하는 데이터(공유)는 Model로 사용하면 되지만, 공통적으로 처리해야 하는 메소드는 @ModelAttribute로 빼놓으면 코드를 간결하게 만들 수 있다.
	@RequestMapping("/search/search1")
	public String search1() {
		return "search/search";
	}
	
	@ModelAttribute("searchTypeList") //searchTypeList는 view 페이지인 jsp 에서 el로 받을 수 있다.
	public List<SearchType> getSearchType(){
		List<SearchType> list = new ArrayList<SearchType>();
		list.add(new SearchType(1,"팀이름+선수이름"));
		list.add(new SearchType(2,"팀이름"));
		list.add(new SearchType(3,"선수이름"));
		return list;
	}
	
	//인기검색어 만들 때 쓰이는 문자열
	@ModelAttribute("queryList") //queryList는 view 페이지인 jsp 에서 el로 받을 수 있다.
	public String[] getQueryList() {
		return new String[] {"손흥민", "이강인", "메시"};
	}
}
