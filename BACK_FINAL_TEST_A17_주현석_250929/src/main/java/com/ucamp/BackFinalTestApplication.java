package com.ucamp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.example.mapper") // MyBatis 이용시 사용
public class BackFinalTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackFinalTestApplication.class, args);
	}

}
