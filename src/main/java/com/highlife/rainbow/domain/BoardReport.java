package com.highlife.rainbow.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
public class BoardReport {

	@Id
	@Column(name = "report_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name = "member_num", referencedColumnName = "member_num")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name = "board_id", referencedColumnName = "board_id")
	private Board board;
	
	
    @Column(updatable = false) // update된 시점에 기존에 저장되어 있던 데이터를 유지
    @CreationTimestamp
	private LocalDateTime regReport;
	private String reportReason;
	
	
}
