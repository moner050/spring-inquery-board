package com.fastcampus.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastcampus.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
