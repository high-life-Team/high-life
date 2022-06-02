package com.highlife.rainbow.service;

import com.highlife.rainbow.member.MemberDTO;


public interface MemberService {
	
	
	
	public int memberinsert(MemberDTO dto);
	
	public MemberDTO login(MemberDTO memberdto);
	
	
}
