package com.highlife.rainbow;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.highlife.rainbow.domain.Board;
import com.highlife.rainbow.domain.Member;
import com.highlife.rainbow.repository.BoardRepository;
import com.highlife.rainbow.repository.MemberRepository;

@SpringBootTest
class RainbowApplicationTests {

	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	MemberRepository memberRepository;
	
	
	@Test
	void saveMemberTest() {
		
		Member member = new Member();
		
		member.setMemberId("user2");
		member.setNickname("test2");
		member.setPassword("test1234");
		member.setEmail("test@test2");
		memberRepository.save(member);
//		saveBoardTest(member.getId());
//        saveBoardTest(member);
		
		Board board = new Board();
		board.setTitle("테스트 제목");
		board.setContent("테스트 내용");
		board.setHide(false);
		board.setHits(0);
		board.setImgPth("temp/path");
		board.setMember(member);
		boardRepository.save(board);
	}
	
//	@Test
//	void saveBoardTest(Member member) {
////		Optional<Member> member = memberRepository.findById(id);
//		Board board = new Board();
//		board.setTitle("테스트 제목");
//		board.setContent("테스트 내용");
//		board.setHide(false);
//		board.setHits(0);
//		board.setImgPth("temp/path");
//		board.setMember(member);
//		boardRepository.save(board);
//	}

}
