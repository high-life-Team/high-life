package com.highlife.rainbow.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.highlife.rainbow.member.MemberDTO;
import com.highlife.rainbow.service.MemberService;

@Controller
public class MemberController {

	@GetMapping("member")
    public String member(){
		
       return "member";
    }
	
	@Autowired
	@Qualifier("memberservice")
	MemberService service;
	
	@RequestMapping(value = "/memberinsert", method = RequestMethod.GET)
	public String insertform() throws Exception {
		return "/member";
	}
	
	
	@RequestMapping(value = "/memberinsert", method = RequestMethod.POST)
	public String insertresult(MemberDTO dto) throws Exception {
		int result = service.memberinsert(dto);// id, email, phone �ߺ� �Ұ���
		System.out.println(result);
		return "redirect:login";
	}
	
	
	
}

