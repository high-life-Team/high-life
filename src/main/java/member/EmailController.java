package member;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmailController {
	
	 private final EmailService emailService;
	 
	    public EmailController(EmailService emailService) {
	        this.emailService = emailService;
	    }
	   
	    @GetMapping("/mail/send") 
	    public String main() {
	        return "emailtest";
	    }
	    
	    @ResponseBody
	    @PostMapping("/mail/send") // 이메일 인증번호 발송
	    public String sendMail(HttpServletRequest request,String userEmail) throws Exception {
	    	
	    	HttpSession session = request.getSession(); // 세션 생성 및 획득
	    	
	        emailService.sendSimpleMessage(session,userEmail);
	        
	        session.setMaxInactiveInterval(30); // 세션 유효시간 설정 10초
	    	int interval = session.getMaxInactiveInterval();
	    	session.setAttribute("interval",interval);
	    	
	        String email_code = (String)request.getSession().getAttribute("email_code");
	        
	        System.out.println("전달받은 이메일 : "+userEmail);
	        System.out.println("세션에 저장된 인증번호 : "+email_code);
	        System.out.println("메일 전송 완료");
	        
	    	return email_code;
	    }
	    
			@PostMapping("/mail/codeCheck") // 이메일 인증번호 일치여부 확인
		    @ResponseBody
		    public Map<String, Object> testAjax(EmailVO emailvo, HttpServletRequest request){
				
				HttpSession session = request.getSession();
		        System.out.println("남은시간 : " + emailvo.getTimer());
				// 세션에 저장된 인증번호
			 	String sessionCode = (String)request.getSession().getAttribute("email_code");
			 	
		        Map<String, Object> result = new HashMap<String, Object>();
		        
		        // 사용자가 입력한 인증번호
		        System.out.println("세션에 저장된 인증번호 : " + sessionCode);
		        System.out.println("사용자가 입력한 인증번호 : " + emailvo.getEmailCode());
		        
		        if(emailvo.getEmailCode().equals(sessionCode) && emailvo.getTimer() > 0) {
		        	result.put("success", "인증이 완료 되었습니다.");
		        }else if(emailvo.getTimer() == 0) {
		        	session.invalidate(); // 세션 삭제
		        	result.put("expire", "인증시간이 만료되었습니다. 다시 발급해주세요.");
		        }else {
		        	result.put("wrong", "인증번호가 일치하지 않습니다.");
		        }
		        
		        return result;
		        
		    }
		
	}
		