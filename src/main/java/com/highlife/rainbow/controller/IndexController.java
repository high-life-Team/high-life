package com.highlife.rainbow.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/")
    public String main(){
		
		logger.info("-----> 인덱스 컨트롤러 실행 확인");
		
       return "index";
    }
	
}
