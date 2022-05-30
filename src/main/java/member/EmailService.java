package member;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmailService  {
	
    // 인증코드 만들기
	public static String createKey() {
		StringBuffer key = new StringBuffer();
		Random rnd = new Random();

		for (int i = 0; i < 8; i++) { // 인증코드 8자리
			int index = rnd.nextInt(3); // 0~2 까지 랜덤

			switch (index) {
			case 0:
				key.append((char) ((int) (rnd.nextInt(26)) + 97));
				//  a~z  (ex. 1+97=98 => (char)98 = 'b')
				break;
			case 1:
				key.append((char) ((int) (rnd.nextInt(26)) + 65));
				//  A~Z 
				break;
			case 2:
				key.append((rnd.nextInt(10)));
				// 0~9
				break;
			}
		}
		return key.toString();
	}
	
	static final String FROM = "no-reply@handemoa.kr";
	static final String FROMNAME = "한데모아";
	
    private JavaMailSender emailSender;
	
    public void sendSimpleMessage(HttpSession session, String userEmail) {
    	
    	InternetAddress address = null;
    	String email_code = createKey();
    	
    	session.setAttribute("email_code", email_code);
    	
	try {
		address = new InternetAddress(FROM,FROMNAME);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(address+"");
        message.setTo(userEmail);
        System.out.println("입력받은 이메일 : " + userEmail);
        message.setSubject("한데모아 이메일 인증번호가 도착했습니다."); // 제목
        message.setText("한데모아의 인증코드는 "+ email_code + " 입니다."); // 내용
        
        System.out.println("인증코드 : " + email_code);
        
        emailSender.send(message);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    }
}