package com.highlife.rainbow.member;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("memberDAO")
public interface MemberDAO {

	//회원가입
	public int memberinsert(MemberDTO dto);
	
	//로그인
	public MemberDTO login(MemberDTO memberdto);

	//ID 찾기
	public String idfind(MemberDTO dto);
	


}
