package com.expertpia.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expertpia.web.domains.Post;
import com.expertpia.web.domains.User;

public abstract interface PostRepository
  extends JpaRepository<Post, Long>
{
  public abstract List<Post> findByUser(User paramUser);
  
  public abstract List<Post> findByPostId(Long paramLong);
  
  public abstract List<Post> findByCommentsPostPostId(Long paramLong);
  
  public abstract List<Post> findByCommentsCommentContent(Long paramLong);
  
  public abstract List<Post> findByPostTitleContainingOrPostContentContaining(String paramString1, String paramString2);
}
