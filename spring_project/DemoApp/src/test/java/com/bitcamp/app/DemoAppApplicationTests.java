package com.bitcamp.app;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoAppApplicationTests {

	@Autowired
	private DataSource dataSource;
	
	private Connection conn;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void testConnection() throws SQLException {
		//별도의 xml 설정 없이도 구동이 된다는 것을 확인하기 위해 작성.
		System.out.println("dataSource >>>>>>>>"+dataSource);
		
		conn = dataSource.getConnection();
		System.out.println("connection >>>>>>>>"+conn);
	}
}
