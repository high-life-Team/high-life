package com.highlife.rainbow.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
		return "redirect:/";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView form() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(MemberDTO dto, RedirectAttributes rAttr, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberDTO logindto = service.login(dto);
		
		if (logindto != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", logindto);
			session.setAttribute("id", logindto.getMember_id());
			session.setAttribute("pkId", logindto.getMember_num());
			session.setAttribute("email", logindto.getEmail());
			session.setAttribute("nickName", logindto.getNickname());
			session.setAttribute("isLogOn", true);
		
			String id = (String) session.getAttribute("id");
			String email = (String) session.getAttribute("email");
			String nickname = (String) session.getAttribute("nickName");
			System.out.println("=====================================");
			System.out.println("로그인 성공");
			System.out.println("아이디 : " + id);
			System.out.println("이메일 : " + email);
			System.out.println("닉네임 : " + nickname);
			System.out.println("=====================================");
			mv.setViewName("redirect:/");
			
		} else {
			rAttr.addAttribute("result", "loginFailed");
			mv.setViewName("redirect:/");
		}
		return mv;
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("isLogOn");
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		return mav;
	}

	
	
	@ResponseBody
	@RequestMapping(value = "/idfind", method = RequestMethod.POST)
	public String idfind(MemberDTO dto) throws Exception {
		String idfindresult = service.idfind(dto);
		System.out.println("=====================idresult : " + idfindresult);
		System.out.println("=====================getmail : " + dto.getEmail() + "nick : "+ dto.getNickname());
		return idfindresult;
	}
	
	@ResponseBody
	@RequestMapping(value = "/pwfind", method = RequestMethod.POST)
	public String pwfind(MemberDTO dto) throws Exception {
		String pwfindresult = service.pwfind(dto);
		System.out.println("=====================passwordresult" + pwfindresult);
		System.out.println("getid : " + dto.getMember_id() + "/" + "getname : " + dto.getNickname() + "/" + "getemail : " + dto.getEmail());
		return pwfindresult;
	}
	
	@ResponseBody
	@RequestMapping(value = "/membercheck", method = RequestMethod.POST)
	public int selectMember(String member_id) throws Exception {
		int result = service.checkmember(member_id);
		System.out.println(result);
		System.out.println(member_id);
		// result = 0 사용o

		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/membercheck_nickname", method = RequestMethod.POST)
	public int selectMember_nickname(String nickname) throws Exception {
		int result = service.checkmember_nickname(nickname);
		System.out.println(result);
		System.out.println(nickname);
		// result = 0 사용o

		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/membercheck_email", method = RequestMethod.POST)
	public int selectMember_email(String email) throws Exception {
		int result = service.checkmember_email(email);
		System.out.println(result);
		System.out.println(email);
		// result = 0 사용o

		return result;
	}
	
	 @RequestMapping(value="/memberedit", method = RequestMethod.GET)
	  
		public String memberedit(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
			HttpSession session = request.getSession();
			
			String nickname = (String) session.getAttribute("nickName");
			String email = (String) session.getAttribute("email");
			model.addAttribute("nickName", nickname);
			model.addAttribute("email", email);
			
			if (session.getAttribute("member") == null) {
				return "redirect:/";
			}
			return "redirect:/";
		}
	
	  
		@RequestMapping(value = "/memberedit", method = RequestMethod.POST)

		public String membereditresult(HttpServletRequest request ,MemberDTO dto) throws Exception {
			int result = service.memberedit(dto);
			System.out.println(result);
			
			HttpSession session = request.getSession();
			session.removeAttribute("member");
			session.removeAttribute("isLogOn");
			
			
			return "redirect:/";
		}
	
}

