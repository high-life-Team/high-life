package com.highlife.rainbow.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.highlife.rainbow.domain.Board;
import com.highlife.rainbow.repository.BoardRepository;

@Controller
public class IndexController {
	
	@Autowired
	BoardRepository boardRepository;

	@GetMapping(value = "/")
    public String main(Model model){
			
		//id 기준으로 top 3만 가져옴 
		Iterable<Board> asc = boardRepository.findTop3ByOrderByIdDesc();
		model.addAttribute("indexnew", asc);
		
		//hits 기준으로 top 3만 가져옴
		Iterable<Board> desc = boardRepository.findTop3ByOrderByHitsDesc();
		model.addAttribute("indexpopular", desc);
		
		
       return "index";
    }
}
