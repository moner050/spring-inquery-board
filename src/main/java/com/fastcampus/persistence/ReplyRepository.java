package com.fastcampus.persistence;

import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fastcampus.domain.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Integer> {

	@Query(name = "SELECT m FROM REPLY m WHERE m.POST_ID = :POST_ID")
	ArrayList<Reply> findByPost_Id(@Param("POST_ID") Integer id);

//	@Query(name = "SELECT m FROM REPLY AS m WHERE m.POST_ID = :POST_ID")
//	Page<Reply> findAllByPost_Id(@Param("POST_ID") Integer id, Pageable pageable);
	
	
}
