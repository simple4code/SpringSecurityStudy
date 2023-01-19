package com.hzc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan(value = {"com.hzc.mapper"})
public class SpringSecurityQuickStartApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				SpringApplication.run(SpringSecurityQuickStartApplication.class, args);

		System.out.println("debug");
	}

}
