package com.iplab.xwq.fblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.iplab.xwq.fblog.dao")
public class FblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(FblogApplication.class, args);
	}

}
