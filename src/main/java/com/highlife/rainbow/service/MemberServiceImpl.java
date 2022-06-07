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
	 


}


