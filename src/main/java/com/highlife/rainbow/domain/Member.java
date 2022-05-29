package com.highlife.rainbow.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Member {

	@Id
	@Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	// Auto Increment 아이디( 등록정보 1, 2, 3...)
	

	@Column(unique = true)
	private String member; // 회원 아이디
	
	@Column(unique = true) // 닉네임 중복?
	private String nickname; // 닉네임
	
	private String pw; // 패스워드
	private boolean status; // 탈퇴여부 (true: 탈퇴 / true: 미탈퇴)
	
	@Column(unique = true)
	private String email;	// 이메일
	
	
    @Column(updatable = false) // update된 시점에 기존에 저장되어 있던 데이터를 유지
    @CreationTimestamp
	private LocalDateTime regDate; // 등록날짜
    
    @Column(updatable = false) // update된 시점에 기존에 저장되어 있던 데이터를 유지
    @CreationTimestamp
	private LocalDateTime withdrawal; // 탈퇴날짜
	
	
    // **** 연관관계 정리 ****
    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Board> board = new ArrayList<>();
	
}
