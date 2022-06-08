package com.highlife.rainbow.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.highlife.rainbow.domain.Board;
import com.highlife.rainbow.domain.BoardReport;
import com.highlife.rainbow.domain.Member;
import com.highlife.rainbow.domain.Reply;
import com.highlife.rainbow.repository.BoardReportRepository;
import com.highlife.rainbow.repository.BoardRepository;
import com.highlife.rainbow.repository.MemberRepository;
import com.highlife.rainbow.repository.ReplyRepository;

@Service
@Transactional
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	private BoardReportRepository boardReportRepository;
	
	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private ReplyRepository replyRepository;

	public Board save(String email, Board board, MultipartFile file) throws IllegalStateException, IOException {
		Member member = memberRepository.findByEmail(email);
		board.setMember(member);
		board.setHits(0);
		board.setAngry(0);
		board.setCheerUp(0);
		board.setLove(0);
		board.setSad(0);
		board.setTotal(0);
		
		if (file.getOriginalFilename() != "") {
			String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\board\\images";
			UUID uuid = UUID.randomUUID();
			String fileName = uuid + "_" + file.getOriginalFilename();
//        String fileName = uuid + "_이미지";
			File saveFile = new File(filePath, fileName);
			file.transferTo(saveFile);
			board.setImgPth("/board/images/" + fileName);
		}
		return boardRepository.save(board);
	}

	public int updateHits(Long id) {
		return boardRepository.updateHits(id);
	}

	public void saveReply(Reply reply, Board board, String email) {

		Member member = memberRepository.findByEmail(email);

		reply.setBoard(board);
		reply.setMember(member);

		replyRepository.save(reply);
	}

	public void deleteReply(Long replyId) {
		replyRepository.deleteById(replyId);
	}

	public void deleteBoard(Long boardId) {
		boardRepository.deleteById(boardId);
	}
	
	public void saveReport(BoardReport report, Board board, int reportCnt, String email, String reason) {
		Member member = memberRepository.findByEmail(email);
		
		report.setMember(member);
		report.setBoard(board);
		report.setReportReason(reason);
		board.setReport(reportCnt);
//		boardRepository.updateBoardReport(board);
		boardReportRepository.save(report);
	}
}
