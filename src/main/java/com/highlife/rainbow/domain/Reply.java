package com.highlife.rainbow.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
public class Reply {
	
	@Id
	@Column(name = "reply_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "board_id", referencedColumnName = "board_id")
	private Board board;
	
	@ManyToOne
	@JoinColumn(name = "member_num", referencedColumnName = "member_num")
	private Member member;
	
	private String content;
	
	
    @Column(updatable = false) // update된 시점에 기존에 저장되어 있던 데이터를 유지
    @CreationTimestamp
	private LocalDateTime regDate;
	
	@Column(name = "reply_hide")
	private boolean hide;
	
	private int reportReason;
	
	private int love;
	
	
    // **** 연관관계 정리 ****
	@OneToMany(mappedBy = "reply")
	private List<ReplyReport> reportes;
	
	
	
}
