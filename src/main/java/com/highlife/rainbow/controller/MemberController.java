package com.highlife.rainbow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

	@GetMapping("member")
    public String member(){
		
       return "member";
    }
    
    
    
	
//	@RequestMapping(value = "memberinsert", method = RequestMethod.GET)
//	public String insertform() throws Exception {
//		return "login";
//	}


//	@RequestMapping(value = "memberinsert", method = RequestMethod.POST)
//	public String insertresult(MemberDTO dto) throws Exception {
//		int result = service.memberinsert(dto); //dto의 값 가져옴
//			System.out.println(result);
//		return "redirect:login";
}
