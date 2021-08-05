package com.bitcamp.firstSpring.dao;

import org.springframework.beans.factory.annotation.Autowired;

public interface Dao {
	
	@Autowired
	void insert();
	public void fileUpload() {
		dao.insert();
	}

}
