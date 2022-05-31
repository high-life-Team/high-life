package com.highlife.rainbow.member;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("memberDAO")
public interface MemberDAO {

	//회원가입
	public int memberinsert(MemberDTO dto);
	
	//public int checkmember(String id);

	//public int checkmember_nickname(String nickname);
	
	//public int checkmember_email(String email);
	
	//public int checkmember_phone(String phone);
	
	
	
	//로그인
	//public MemberDTO login(MemberDTO memberdto);

	
	
	
	//회원탈퇴
	//public int memberquit(String status);
	
	
	
	//회원 정보 수정
	//public int memberedit(MemberDTO dto);
	
	
	//ID 찾기
	//public String idfind(MemberDTO dto);
	
	//PW 찾기
	//public String pwfind(MemberDTO dto);

}
