package com.highlife.rainbow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.highlife.rainbow.domain.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long>{

}
