package com.highlife.rainbow.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.highlife.rainbow.domain.Board;
import com.highlife.rainbow.domain.Member;
import com.highlife.rainbow.domain.Reply;
import com.highlife.rainbow.repository.BoardRepository;
import com.highlife.rainbow.repository.MemberRepository;
import com.highlife.rainbow.repository.ReplyRepository;

@Service
@Transactional
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;
    
    @Autowired
    private MemberRepository memberRepository;
    
    @Autowired
	private ReplyRepository replyRepository;
    
    
    public Board save(Member member, Board board) {
        board.setMember(member);
        board.setHits(0);
        return boardRepository.save(board);
     }
    
    
    public int updateHits(Long id) {
        return boardRepository.updateHits(id);
    }

    public void saveReply(Reply reply, Board board, Long id) {

        Member member = memberRepository.findById(id).get();

        reply.setBoard(board);
        reply.setMember(member);

        replyRepository.save(reply);
    }

    public void deleteReply(Long replyId) {
        replyRepository.deleteById(replyId);
    }
}
