package member;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component("memberDTO")
public class MemberDTO {
	String id;
	String nickname;
	String password;
	String email;
	String phone;
	String birth;
	String regdate;
	int status;
	String quitdate;
	String profileimg;
	String intro;
}
