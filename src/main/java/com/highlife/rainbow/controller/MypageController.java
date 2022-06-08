package com.highlife.rainbow.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.highlife.rainbow.domain.Board;
import com.highlife.rainbow.repository.BoardRepository;
import com.highlife.rainbow.service.BoardService;

@Controller
public class MypageController {

	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private BoardService boardService;
	
	
	@GetMapping(value = "/mypage")
	public String main(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
//		Board board = boardRepository.findById(boardId).get();
		String memberId = (String) session.getAttribute("pkId");
		System.out.println("===============================");
		System.out.println(memberId);
		System.out.println(session.getAttribute("pkId"));
		System.out.println("===============================");
		String nickName = (String) session.getAttribute("nickName");
		model.addAttribute("memberId", memberId);
		model.addAttribute("nickName", nickName);
		
		Iterable<Board> asc = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
		model.addAttribute("boards", asc);
		
		
		return "mypage";
	}
	


}
