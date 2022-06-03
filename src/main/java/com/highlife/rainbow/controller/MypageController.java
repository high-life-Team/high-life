package com.highlife.rainbow.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MypageController {

	@GetMapping(value = "/mypage")
    public String main(){
		
       return "mypage";
    }
	
}
