package com.housh.springmybatisdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(value = "com.housh.springmybatisdemo.mapper")
public class SpringmybatisdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmybatisdemoApplication.class, args);
	}
}
