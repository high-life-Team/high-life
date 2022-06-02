package com.highlife.rainbow.member;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component("memberDTO")
public class MemberDTO {
	String member_num;
	String member_id;
	String nickname;
	String password;
	String email;
	String reg_date;
	int status;
	String withdrawal;
}
