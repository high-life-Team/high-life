package com.highlife.rainbow.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	

	@GetMapping("login")
    public String login(){
       return "login";
    }
}
