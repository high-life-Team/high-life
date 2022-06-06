package com.highlife.rainbow.repository;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.highlife.rainbow.domain.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>{
	
    List<Board> findByTitleOrContent(String title, String content);
    Page<Board> findByOrderByIdDesc(Pageable pageable);
    
		@Modifying
	    @Query("update Board p set p.hits = p.hits + 1 where p.id = :id")
	    int  updateHits(@Param("id") Long id);
}
