package com.bitcamp.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

//mapper를 괄호 안의 패키지 에서 찾을 수 있게 하는 기능
@MapperScan("com.bitcamp.app.member.mapper")
public class DemoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAppApplication.class, args);
	}

}
