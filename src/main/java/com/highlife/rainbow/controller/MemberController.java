package com.highlife.rainbow.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.highlife.rainbow.member.MemberDTO;
import com.highlife.rainbow.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	@Qualifier("memberservice")
	MemberService service;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

		
	@GetMapping("member")
    public String member(){
		
		logger.info("-----> 로그인 컨트롤러 실행 확인");
		
		System.out.println("로그인 컨트롤러 실행 확인");
		
       return "member";
    }
    
    
    
	
	@RequestMapping(value = "memberinsert", method = RequestMethod.GET)
	public String insertform() throws Exception {
		return "login";
	}


	@RequestMapping(value = "memberinsert", method = RequestMethod.POST)
	public String insertresult(MemberDTO dto) throws Exception {
		int result = service.memberinsert(dto); //dto의 값 가져옴
			System.out.println(result);
		return "redirect:login";
}

}
