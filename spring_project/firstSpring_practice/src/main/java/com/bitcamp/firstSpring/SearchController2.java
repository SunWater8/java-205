package com.bitcamp.firstSpring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.firstSpring.domain.SearchType;

@Controller
public class SearchController2 {

	@RequestMapping("/search/search2")
	public void searchPage() {
		
	}
	
	@ModelAttribute("searchTypeList")
	public List<SearchType> getSearchType(){
		List<SearchType> list = new ArrayList<>();
		list.add(new SearchType(1, "팀이름+선수이름"));
		list.add(new SearchType(2, "팀이름"));
		list.add(new SearchType(3, "선수이름"));
		return list;
	}
}
