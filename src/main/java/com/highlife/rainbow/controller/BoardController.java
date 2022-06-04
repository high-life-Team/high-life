package com.highlife.rainbow.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.highlife.rainbow.domain.Board;
import com.highlife.rainbow.domain.Member;
import com.highlife.rainbow.domain.Reply;
import com.highlife.rainbow.member.MemberDTO;
import com.highlife.rainbow.repository.BoardRepository;
import com.highlife.rainbow.repository.MemberRepository;
import com.highlife.rainbow.service.BoardService;
import com.highlife.rainbow.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardRepository boardRepository;

	@Autowired
	private BoardService boardService;

	@Autowired
	private MemberRepository memberRepository;

	@GetMapping("list")
	public String lists() {
		return "board";
	}

	@GetMapping("detail")
	public String detail() {
		return "detail";
	}

	@Autowired
	@Qualifier("memberservice")
	MemberService memberService;

	@GetMapping("/form")
	public String form(Model model, @RequestParam(required = false) Long id) {
		System.out.println("getMapping ==========================");
		if (id == null) {
			System.out.println("아이디가 없음");
			model.addAttribute("board", new Board());
			model.addAttribute("localDateTime", LocalDateTime.now());
		} else {
			System.out.println("아이디가 있음");
			Board board = boardRepository.findById(id).orElse(null);
			model.addAttribute("board", board);
		}

		return "form";
	}

	@PostMapping("/form")
	public String greetingSubmit(@Valid Board board, BindingResult bindingResult, HttpServletRequest request,
			MemberDTO dto) {
		if (bindingResult.hasErrors()) {
			System.out.println("postmapping if문==========================");
			return "board";
		}

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		System.out.println("dto not null==========================");
		boardService.save(email, board);

//      Member member = memberRepository.findByUserEmail(userName);

		return "board";
	}

	@PostMapping("/reply/create")
	public String createReply(@Valid Reply reply, BindingResult bindingResult, @RequestParam Long boardId, Model model,
			Member member, MemberDTO dto, HttpServletRequest request) {

		ModelAndView mv = new ModelAndView();
		MemberDTO logindto = memberService.login(dto);

		if (logindto != null) {
			HttpSession session = request.getSession();

//      Board board = boardRepository.getById(boardId);
//    	String userEmail = authentication.getName();			// ==> 현재 로그인한 사용자 정보를 security를 사용하지 않으면 어떻게 받아오는지..
			Board board = boardRepository.findById(boardId).get();
//      String nickName = member.getNickname();
			String nickName = (String) session.getAttribute("nickName");

			System.out.println("=====================================");
			System.out.println(nickName);
			System.out.println("=====================================");
			Long memberId = member.getId();
			model.addAttribute("board", board);
			model.addAttribute("nickName", nickName);
			model.addAttribute("replyList", board.getReplies());

			if (bindingResult.hasErrors()) {
				return "board/read";
			}

			model.addAttribute("reply", new Reply());
			boardService.saveReply(reply, board, memberId);
		}
		return "redirect:/board/read?id=" + boardId;

	}

	@PostMapping("/reply/delete")
	public String deleteReply(@RequestParam Long replyId, @RequestParam Long boardId, Model model, Member member) {

		boardService.deleteReply(replyId);

//        Board board = boardRepository.getById(boardId);
//        String userEmail = authentication.getName();
		Board board = boardRepository.findById(boardId).get();
		String nickName = member.getNickname();

		model.addAttribute("board", board);
		model.addAttribute("nickName", nickName);
		model.addAttribute("replyList", board.getReplies());
		model.addAttribute("reply", new Reply());

		return "redirect:/board/read?id=" + boardId;
	}
}
