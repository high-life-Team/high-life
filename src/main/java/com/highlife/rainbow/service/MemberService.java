package com.highlife.rainbow.service;

import com.highlife.rainbow.member.MemberDTO;


public interface MemberService {
	
	
	
	public int memberinsert(MemberDTO dto);
	
	public int checkmember(String member_id);
	
	public int checkmember_nickname(String nickname);
	
	public int checkmember_email(String email);
	
	//
	public MemberDTO login(MemberDTO memberdto);
	
	//ID 찾기
	public String idfind(MemberDTO dto);
	
	//PW 찾기
	public String pwfind(MemberDTO dto);
}
