package com.highlife.rainbow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class memberController {

	@GetMapping("login")
    public String log(){
       return "login";
    }
}
