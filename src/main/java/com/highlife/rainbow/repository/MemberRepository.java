package com.highlife.rainbow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.highlife.rainbow.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
	
	Member findByEmail(String Email);
}
