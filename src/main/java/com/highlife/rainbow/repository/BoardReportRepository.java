package com.highlife.rainbow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.highlife.rainbow.domain.BoardReport;

public interface BoardReportRepository extends JpaRepository<BoardReport, Long> {
	
}
