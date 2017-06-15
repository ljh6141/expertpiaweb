package com.expertpia.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expertpia.test.domain.Comment;
import com.expertpia.test.domain.Post;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	List<Comment> findByPost(Post post);
	List<Comment> findByCommentId(Long id);  
}
