package com.highlife.rainbow.member;

import java.time.LocalDateTime;

import com.highlife.rainbow.domain.Board;
import com.highlife.rainbow.domain.Member;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BoardDTO {
    private Long id;

    private Member member;

    private Integer hits;

    private LocalDateTime regDate;

    private String title;

    private String content;


    public void setBoardDto(Board board) {
        this.id = board.getId();
        this.member = board.getMember();
        this.hits = board.getHits();
        this.regDate = board.getRegDate();
        this.title = board.getTitle();
        this.content = board.getContent();
//        this.replies = null;
    }
}