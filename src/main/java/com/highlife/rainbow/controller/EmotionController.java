package com.highlife.rainbow.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.highlife.rainbow.domain.Board;
import com.highlife.rainbow.domain.Emotion;
import com.highlife.rainbow.domain.Member;
import com.highlife.rainbow.repository.BoardRepository;
import com.highlife.rainbow.repository.MemberRepository;
import com.highlife.rainbow.service.EmotionService;

@Controller
public class EmotionController {

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private EmotionService emotionService;
	
	@PostMapping("/like")
	public String like(@RequestParam Long boardId, Model model, Member member,
			HttpServletRequest request) {
		Board board = boardRepository.findById(boardId).get();
//		Emotion board = board.getEmotion();
		emotionService.savelike(board, board.getLove()+1);
		emotionService.saveTotal(board, board.getTotal()+1);
//		emotionService.updateLike(boardId);
		return "redirect:/board/detail?id=" + boardId;
	}
	
	@PostMapping("/angry")
	public String angry(@RequestParam Long boardId, Model model, Member member,
			HttpServletRequest request) {
		
		Board board = boardRepository.findById(boardId).get();
//		Emotion board = board.getEmotion();
		emotionService.saveAngry(board, board.getAngry()+1);
		emotionService.saveTotal(board, board.getTotal()-1);
//		emotionService.updateAngry(boardId);
		return "redirect:/board/detail?id=" + boardId;
	}
	
	@PostMapping("/sad")
	public String sad(@RequestParam Long boardId, Model model, Member member,
			HttpServletRequest request) {
		
		Board board = boardRepository.findById(boardId).get();
//		Emotion board = board.getEmotion();
		emotionService.saveSad(board, board.getSad()+1);
//		emotionService.updateSad(boardId);
		return "redirect:/board/detail?id=" + boardId;
	}
	
	@PostMapping("/cheer/up")
	public String cheerUp(@RequestParam Long boardId, Model model, Member member,
			HttpServletRequest request) {
		
		Board board = boardRepository.findById(boardId).get();
//		Emotion board = board.getEmotion();

		emotionService.saveCheerUp(board, board.getCheerUp()+1);
		emotionService.saveTotal(board, board.getTotal()+1);
//		emotionService.updateCheerUp(boardId);
		return "redirect:/board/detail?id=" + boardId;
	}
}
