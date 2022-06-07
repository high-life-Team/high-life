package com.highlife.rainbow.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.highlife.rainbow.domain.Board;
import com.highlife.rainbow.domain.Member;
import com.highlife.rainbow.domain.Reply;
import com.highlife.rainbow.member.MemberDTO;
import com.highlife.rainbow.repository.BoardRepository;
import com.highlife.rainbow.repository.MemberRepository;
import com.highlife.rainbow.service.BoardService;
import com.highlife.rainbow.service.MemberService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardRepository boardRepository;

	@Autowired
	private BoardService boardService;

	@Autowired
	private MemberRepository memberRepository;

//	@GetMapping("list")	// 오래된 순
//	public String list(Model model,
//			@PageableDefault(size = 20, sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
//			@RequestParam(required = false, defaultValue = "") String searchText) {
//		
////		List<Member> findByUsername(String name, Sort sort);
//
////		Page<Board> boards = boardRepository.findByOrderByIdAsc(pageable);
//
////int startPage = Math.max(1, boards.getPageable().getPageNumber() - 4);
////int endPage = Math.min(boards.getTotalPages(), boards.getPageable().getPageNumber() + 4);
////		int nowPage = boards.getPageable().getPageNumber() + 1;
////		int startPage = Math.max(1, nowPage - 2);
////		int endPage = Math.min(startPage + 2, boards.getTotalPages());
////
////		model.addAttribute("startPage", startPage);
////		model.addAttribute("endPage", endPage);
////		Iterable<Board> orderIterator = boardRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
////		model.addAttribute("boards", orderIterator);
//		return "board";
//	}

	@GetMapping("list") // 최신 순
	public String oldList(Model model) {
		Iterable<Board> asc = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
		model.addAttribute("boards", asc);
		return "board";
	}

	@GetMapping("old") // 오래된 순
	public String newList(Model model) {
		Iterable<Board> desc = boardRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
		model.addAttribute("boards", desc);
		return "board";
	}
	
	@GetMapping("hits") // 조회 순 
	public String hitsList(Model model) {
		Iterable<Board> desc = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "hits"));
		model.addAttribute("boards", desc);
		return "board";
	}

	@GetMapping("detail")
	public String detail(Model model, @RequestParam(required = false) Long id, HttpServletRequest request) {
		if (id == null) {
			model.addAttribute("board", new Board());
		} else {
			HttpSession session = request.getSession();
			String email = (String) session.getAttribute("email");
			String nickName = (String) session.getAttribute("nickName");
			String memberId = (String) session.getAttribute("pkId");
			Board board = boardRepository.findById(id).orElse(null);
			System.out.println("==================================");
			System.out.println("memberId : " + memberId.getClass().getName());
			System.out.println("board.getId : " + board.getMember().getId().toString().getClass().getName());
			System.out.println("==================================");
			boardService.updateHits(board.getId());
			model.addAttribute("board", board);
			model.addAttribute("nickname", nickName);
			model.addAttribute("reply", new Reply());
			model.addAttribute("userEmail", email);
			model.addAttribute("replyList", board.getReplies());
			Member member = memberRepository.findByEmail(email);
			System.out.println("==================================");
			System.out.println("memberId : " + memberId);
			System.out.println("board.getId : " + board.getMember().getId().toString());
			System.out.println("==================================");
			model.addAttribute("memberId", memberId);
			model.addAttribute("getId", board.getMember().getId().toString());
		}

		return "detail";
	}

	@GetMapping("delete")
	public String boardDelete(Long id) {
		boardService.deleteBoard(id);
		return "detail";
	}

	@Autowired
	@Qualifier("memberservice")
	MemberService memberService;

	@GetMapping("/form")
	public String form(Model model, @RequestParam(required = false) Long id,  MultipartFile file) {
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

		return "redirect:/board/list";
	}

	@PostMapping("/reply/create")
	public String createReply(@Valid Reply reply, BindingResult bindingResult, @RequestParam Long boardId, Model model,
			Member member, MemberDTO dto, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		MemberDTO logindto = memberService.login(dto);

//		if (logindto != null) {
		HttpSession session = request.getSession();
		System.out.println("boardId : " + boardId);
		System.out.println("member: " + member.getId());
//      Board board = boardRepository.getById(boardId);
//    	String userEmail = authentication.getName();			// ==> 현재 로그인한 사용자 정보를 security를 사용하지 않으면 어떻게 받아오는지..
		Board board = boardRepository.findById(boardId).get();
//      String nickName = member.getNickname();
		String nickName = (String) session.getAttribute("nickName");
		String email = (String) session.getAttribute("email");
		String memberId = (String) session.getAttribute("id");
		System.out.println("=====================================");
		System.out.println("memberId : " + member.getId());
		System.out.println("nickName : " + nickName);
		System.out.println("memberId : " + memberId);
		System.out.println("email : " + email);
		System.out.println("=====================================");

		model.addAttribute("memberId", memberId);
		model.addAttribute("board", board);
		model.addAttribute("nickName", nickName);
		model.addAttribute("replyList", board.getReplies());
		model.addAttribute("email", email);
		if (bindingResult.hasErrors()) {
			return "board/detail";
		}

		model.addAttribute("reply", new Reply());
		boardService.saveReply(reply, board, email);
//		}
		return "redirect:/board/detail?id=" + boardId;

	}

	@PostMapping("/reply/delete")
	public String deleteReply(@RequestParam Long replyId, @RequestParam Long boardId, Model model, Member member,
			HttpServletRequest request) {

		HttpSession session = request.getSession();
		String nickName = (String) session.getAttribute("nickName");
		String memberId = (String) session.getAttribute("pkId");
		System.out.println("============댓글 딜리트문입니다=======");
		boardService.deleteReply(replyId);

//        Board board = boardRepository.getById(boardId);
//        String userEmail = authentication.getName();
		Board board = boardRepository.findById(boardId).get();
		model.addAttribute("board", board);
//		model.addAttribute("ootd", nickName);
		model.addAttribute("memberId", memberId);
		model.addAttribute("replyList", board.getReplies());
		model.addAttribute("reply", new Reply());

		return "redirect:/board/detail?id=" + boardId;
	}
}
