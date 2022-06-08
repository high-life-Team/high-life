package com.highlife.rainbow.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
public class Board {
	
	@Id
	@Column(name = "board_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "member_num", referencedColumnName = "member_num") // member의 PK를 받아옴
	private Member member;
	
    @NotBlank(message = "제목을 입력해 주세요!")
	private String title;
	
    @NotBlank(message = "내용을 입력해 주세요!")
	private String content;
	
    @Column(name = "reg_date", updatable = false) // update된 시점에 기존에 저장되어 있던 데이터를 유지
    @CreationTimestamp
    private LocalDateTime regDate;
    
    @Column(columnDefinition = "integer default 0")
    private Integer hits;
    
    @Column(name = "board_hide")
    private boolean hide;
    
    private String imgPth;
    
    @Column(name = "report_cnt")
    private int report;
    
    
    // **** 연관관계 정리 ****
    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
    private List<Reply> replies;
    
    @OneToOne(mappedBy = "board", cascade = CascadeType.REMOVE)
    private Emotion emotion;

	@OneToMany(mappedBy = "board")
	private List<BoardReport> reportes;
	
	  @Builder
	    public Board(String title, String content, LocalDateTime regDate, Member member) {
	        this.title = title;
	        this.content = content;
	        this.regDate = regDate;
	        this.member = member;
	    }
	  
		private int love;
		private int sad;
		private int cheerUp;
		private int angry;
		private int total; // 위 4가지 감정 종합 cnt
}
