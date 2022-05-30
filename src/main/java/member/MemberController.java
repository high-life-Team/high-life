package com.highlife.rainbow.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.highlife.rainbow.service.MemberService;

import member.MemberDTO;

@Controller
public class MemberController {
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
	
	@RequestMapping(value = "/adminlogin", method = RequestMethod.GET)
	public String adminlogin() throws Exception {
		return "adminlogin";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public String admin() throws Exception {
		return "admin";
	}
	
	@RequestMapping(value = "/adminlogout", method = RequestMethod.GET)
	public String logout() throws Exception {
		return "adminlogout";
	}
	
	@ResponseBody
	@RequestMapping(value = "/membercheck", method = RequestMethod.POST)
	public int selectMember(String id) throws Exception {
		int result = service.checkmember(id);
		System.out.println(result);
		System.out.println(id);
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
	
	@ResponseBody
	@RequestMapping(value = "/membercheck_phone", method = RequestMethod.POST)
	public int selectMember_phone(String phone) throws Exception {
		int result = service.checkmember_phone(phone);
		System.out.println(result);
		System.out.println(phone);
		// result = 0 사용o

		return result;
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
			session.setAttribute("isLogOn", true);
			
			mv.setViewName("redirect:/handemoa");		
			
		} else {
			rAttr.addAttribute("result", "loginFailed");
			mv.setViewName("redirect:/login");
		}
		return mv;
	}
	
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("isLogOn");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/handemoa");
		return mav;
	}
	
	  @RequestMapping(value="/memberedit", method = RequestMethod.GET)
	  
		public String memberedit(HttpServletRequest request, HttpServletResponse response) throws Exception {
			HttpSession session = request.getSession();
			if (session.getAttribute("member") == null) {
				return "redirect:/login";
			}
			return "memberedit";
		}
	
	  
		@RequestMapping(value = "/memberedit", method = RequestMethod.POST)

		public String membereditresult(HttpServletRequest request ,MemberDTO dto) throws Exception {
			int result = service.memberedit(dto);
			System.out.println(dto.id);
			System.out.println(dto.intro);
			System.out.println(dto.nickname);
			System.out.println(dto.password);
			System.out.println(dto.phone);
			System.out.println(result);
			
			HttpSession session = request.getSession();
			session.removeAttribute("member");
			session.removeAttribute("isLogOn");
			
			return "redirect:/handemoa";
		}
	 
	  
	 
@ResponseBody
@RequestMapping(value = "/memberquit", method = RequestMethod.POST)
public int memberquit(HttpServletRequest request) {
   String ajaxMsg = request.getParameter("memberquit_id");
      int result = service.memberquit(ajaxMsg);
      System.out.println("=====================result" + result);
   return result;
	}


@PostMapping("/profileimg")
@ResponseBody
public String uploadresult(MultipartFile profileimgadd, Model model) throws IOException{ /*한개*/
	
	String profileimgName = null;
	
	MultipartFile mf1 = profileimgadd; /*2*/
	System.out.println("getOriginalFilename:"+mf1.getOriginalFilename()); //업로드한 파일이름
	System.out.println("getSize:"+mf1.getSize()); //길이
	System.out.println("isEmpty:"+mf1.isEmpty()); //파일선택여부

	// 파일내용+파일명--> 서버 c:/upload 폴더 영구 저장
	String savePath = "src\\main\\resources\\static\\css\\images\\";


	if(!mf1.isEmpty()) {
		//원래파일명
		String originname1 = mf1.getOriginalFilename();
		//확장자 이전파일 명
		String beforeext1 = originname1.substring(0, originname1.indexOf("."));
		//확장자 이후
		String ext1 = originname1.substring(originname1.indexOf("."));
		//경로 뺀 이름+확장자
		profileimgName = beforeext1+"("+UUID.randomUUID().toString()+")"+ext1;
		System.out.println(profileimgName);
		File serverfile1 = new File(savePath + profileimgName); 
		mf1.transferTo(serverfile1);
	} else {
		return "login_before.png";
	}
	
	return profileimgName;
}

@RequestMapping(value = "/header", method = RequestMethod.GET)
public String header() throws Exception {
	return "/header";
}

@ResponseBody
@RequestMapping(value = "/idfind", method = RequestMethod.POST)
public String idfind(MemberDTO dto) throws Exception {
	String idfindresult = service.idfind(dto);
	System.out.println("=====================idresult" + idfindresult);
	return idfindresult;
}

@ResponseBody
@RequestMapping(value = "/pwfind", method = RequestMethod.POST)
public String pwfind(MemberDTO dto) throws Exception {
	String pwfindresult = service.pwfind(dto);
	System.out.println("=====================passwordresult" + pwfindresult);
	return pwfindresult;
}

}
