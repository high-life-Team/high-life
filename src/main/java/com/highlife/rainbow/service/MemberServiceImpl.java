package com.highlife.rainbow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.highlife.rainbow.member.MemberDAO;
import com.highlife.rainbow.member.MemberDTO;


@Service("memberservice")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	@Qualifier("memberDAO")
	MemberDAO dao;

	@Override
	public int memberinsert(MemberDTO dto) {
		return dao.memberinsert(dto);
	}
	
	@Override
	public int checkmember(String member_id) {
		return dao.checkmember(member_id);
	}
	@Override
	public int checkmember_nickname(String nickname) {
		return dao.checkmember_nickname(nickname);
	}
	
	@Override
	public int checkmember_email(String email) {
		return dao.checkmember_email(email);
	}

	
	@Override
	public MemberDTO login(MemberDTO memberdto) {
		return dao.login(memberdto);
	}

	@Override
	public String idfind(MemberDTO dto) {
		return dao.idfind(dto);
	}

	@Override
	public String pwfind(MemberDTO dto) {
		return dao.pwfind(dto);
	}
	
	public int memberedit(MemberDTO dto) {
		return dao.memberedit(dto);
	}


}


