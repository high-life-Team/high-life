package com.highlife.rainbow.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.highlife.rainbow.domain.Board;
import com.highlife.rainbow.repository.BoardRepository;
import com.highlife.rainbow.service.BoardService;

@Controller
public class IndexController {
	

	@Autowired
	BoardRepository boardRepository;
	
	
	@Autowired
	private BoardService boardService;

	
	/*
	@GetMapping(value = "/")
	public String main(Model model){
		
	
		//id 기준으로 top 3만 가져옴 
		Iterable<Board> asc = boardRepository.findTop3ByOrderByIdDesc();
		model.addAttribute("indexnew", asc);
		
		//hits 기준으로 top 3만 가져옴
		Iterable<Board> desc = boardRepository.findTop3ByOrderByHitsDesc();
		model.addAttribute("indexpopular", desc);
		
		
       return "index";
    } */
	
	
	
	
	//테스트 코드
	
	
	

	
	
	
	
	@GetMapping(value = "/")
	public String form(Model model, @RequestParam(required = false) Long id, MultipartFile file  ) {
		
		//id 기준으로 top 3만 가져옴 
				Iterable<Board> asc = boardRepository.findTop3ByOrderByIdDesc();
				model.addAttribute("indexnew", asc);
				
				//hits 기준으로 top 3만 가져옴
				Iterable<Board> desc = boardRepository.findTop3ByOrderByHitsDesc();
				model.addAttribute("indexpopular", desc);

		if (id == null) {
			System.out.println("아이디 없음");
			model.addAttribute("board", new Board());
			model.addAttribute("localDateTime", LocalDateTime.now());
		} else {
			System.out.println("아이디 있음");
			Board board = boardRepository.findById(id).orElse(null);
			model.addAttribute("board", board);
		}
		
		

		return "index";
	} 
	

	@PostMapping(value = "/")
	public String greetingSubmit(@Valid Board board, BindingResult bindingResult, HttpServletRequest request,  MultipartFile file) throws IllegalStateException, IOException {
		if (bindingResult.hasErrors()) {
			System.out.println("postmapping if문==========================");
			return "board";
		}

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		System.out.println("file 이름이모: " + file);
		boardService.save(email, board, file);
		
//      Member member = memberRepository.findByUserEmail(userName);

		return "redirect:/";
	}
	
	
	//테스트 코드
}
