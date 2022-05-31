package com.highlife.rainbow.member;

import org.springframework.stereotype.Component;


@Component("memberDTO")
public class MemberDTO {
	String member_num; //유저 고유넘버 
	String email; // 닉네임
	String member_id; //유저 아이디
	String reg_date; //회원가입일
	String withdrawal; //회원탈퇴일
	int status; //회원탈퇴여부
}
