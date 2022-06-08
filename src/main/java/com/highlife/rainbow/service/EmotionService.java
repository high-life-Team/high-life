package com.highlife.rainbow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.highlife.rainbow.domain.Board;
import com.highlife.rainbow.domain.Emotion;
import com.highlife.rainbow.repository.BoardRepository;
import com.highlife.rainbow.repository.MemberRepository;

@Service
public class EmotionService {

	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
//	private EmotionRepository emotionRepository;
	
	public void saveTotal(Board board, int total) {
		board.setTotal(total);
		boardRepository.save(board);
	}
	
	public void savelike(Board board, int like) {
		board.setLove(like);
		boardRepository.save(board);
	}
	public void saveAngry(Board board, int angry) {
		board.setAngry(angry);
		boardRepository.save(board);
	}
	
	public void saveSad(Board board, int sad) {
		board.setSad(sad);
		boardRepository.save(board);
	}
	
	public void saveCheerUp(Board board, int cheerUp) {
		board.setCheerUp(cheerUp);
		boardRepository.save(board);
	}
	
//	public int updateLike(Long id) {
//		return emotionRepository.updateLike(id);
//	}
//	
//	public int updateAngry(Long id) {
//		return emotionRepository.updateAngry(id);
//	}
//	
//	public int updateSad(Long id) {
//		return emotionRepository.updateSad(id);
//	}
//	
//	public int updateCheerUp(Long id) {
//		return emotionRepository.updateCheerUp(id);
//	}
//	
//	public int updateTotal(Long id) {
//		return emotionRepository.updateTotal(id);
//	}
}
