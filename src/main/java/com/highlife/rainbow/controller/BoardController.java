package com.highlife.rainbow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

	@GetMapping("list")
	public String lists() {
		return "board";
	}
	
	@GetMapping("detail")
	public String detail() {
		return "detail";
	}
	
	@GetMapping("form")
	public String form() {
		return "form";
	}
}
