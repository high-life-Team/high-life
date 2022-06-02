package com.highlife.rainbow;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan
@ComponentScan(basePackages = "com.highlife.rainbow.controller")
@ComponentScan(basePackages = "com.highlife.rainbow.service")
@MapperScan(basePackages = "com.highlife.rainbow.member")


public class RainbowApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(RainbowApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
			return builder.sources(RainbowApplication.class);
		}

}
