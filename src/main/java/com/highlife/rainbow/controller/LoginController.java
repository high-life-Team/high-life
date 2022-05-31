package com.highlife.rainbow.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("login")
    public String login(){
		
		logger.info("-----> 로그인 컨트롤러 실행 확인");
		
		System.out.println("로그인 컨트롤러 실행 확인");
		
       return "login";
    }
}
