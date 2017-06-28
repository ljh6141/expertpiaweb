package com.expertpia.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expertpia.web.domains.Comment;
import com.expertpia.web.domains.Post;

public abstract interface CommentRepository
  extends JpaRepository<Comment, Long>
{
  public abstract List<Comment> findByPost(Post paramPost);
  
  public abstract List<Comment> findByCommentId(Long paramLong);
  
  public abstract List<Comment> findByPostPostId(Long paramLong);
}
