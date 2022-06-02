package com.highlife.rainbow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.highlife.rainbow.domain.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>{
	
		@Modifying
	    @Query("update Board p set p.hits = p.hits + 1 where p.id = :id")
	    int  updateHits(@Param("id") Long id);
}
