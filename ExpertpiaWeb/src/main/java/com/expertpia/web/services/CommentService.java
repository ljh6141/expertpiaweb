package com.expertpia.web.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expertpia.web.domains.Comment;
import com.expertpia.web.domains.Post;
import com.expertpia.web.repositories.CommentRepository;
import com.expertpia.web.repositories.PostRepository;

@Transactional
@Service
public class CommentService
{
  @Autowired
  private PostRepository postRepository;
  @Autowired
  private CommentRepository commentRepository;
  
  public List<Comment> getlist()
  {
    return this.commentRepository.findAll();
  }
  
  public Comment getComment(Long id)
  {
    Comment comments = (Comment)this.commentRepository.findOne(id);
    return comments;
  }
  
  public Comment create(Comment comment)
  {
    Comment comments = (Comment)this.commentRepository.save(comment);
    Long postId = comment.getPost().getPostId();
    Post posts = (Post)this.postRepository.findOne(postId);
    
    posts.setReplyCount(Long.valueOf(posts.getReplyCount().longValue() + 1L));
    return comments;
  }
  
  public Comment update(Comment comment, Long id)
  {
    comment.setCommentId(id);
    this.commentRepository.save(comment);
    return comment;
  }
  
  public Comment delete(Long id)
  {
    Comment comment = (Comment)this.commentRepository.findOne(id);
    Long postId = comment.getPost().getPostId();
    this.commentRepository.delete(comment);
    Post posts = (Post)this.postRepository.findOne(postId);
    
    posts.setReplyCount(Long.valueOf(posts.getReplyCount().longValue() - 1L));
    return comment;
  }
}
