package com.highlife.rainbow.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
public class Emotion {
	@Id
	@Column(name = "emotion_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    // **** 연관관계 정리 ****
	@OneToOne
	@JoinColumn(name = "member_num", referencedColumnName = "member_num") // member의 PK를 받아옴
	private Member member;
	
	@OneToOne
	@JoinColumn(name = "board_id", referencedColumnName = "board_id")
	private Board board;
	
	
	private int love;
	private int sad;
	private int cheerUp;
	private int angry;
	private int total; // 위 4가지 감정 종합 cnt
	
}
