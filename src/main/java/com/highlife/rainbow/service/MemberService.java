package com.highlife.rainbow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.highlife.rainbow.domain.Member;
import com.highlife.rainbow.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
	@Autowired
	private final MemberRepository memberRepository;
	
	public Member MemberSave(Member member) {
		return memberRepository.save(member);
	}
}
