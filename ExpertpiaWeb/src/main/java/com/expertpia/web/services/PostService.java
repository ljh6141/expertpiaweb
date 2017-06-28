package com.expertpia.web.services;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expertpia.web.domains.Comment;
import com.expertpia.web.domains.Post;
import com.expertpia.web.repositories.CommentRepository;
import com.expertpia.web.repositories.PostRepository;

@Transactional
@Service
public class PostService
{
  private Logger logger = LoggerFactory.getLogger(PostService.class);
  EntityManager em;
  @Autowired
  private PostRepository postRepository;
  @Autowired
  private CommentRepository commentRepository;
  
  public List getlist()
  {
    String jpql = "select a from test_posts a join fetch p.comments";
    List<Post> posts = this.em.createQuery(jpql, Post.class)
      .getResultList();
    
    return posts;
  }
  
  public List<Post> getlist2()
  {
    return this.postRepository.findAll();
  }
  
  @Transactional
  public Post getPostInfo(Long id)
  {
    Post posts = (Post)this.postRepository.findOne(id);
    
    List<Comment> comments = posts.getComments();
    
    return posts;
  }
  @Transactional
  public List<Comment> getCommentInfo(Long id)
  {
    List<Comment> comments = this.commentRepository.findByPostPostId(id);
    return comments;
  }
  
  public List getCommentInfo2()
  {
    List<Comment> comments = this.commentRepository.findAll();
    return comments;
  }

  public List<Post> getPoCo(Long id)
  {
    List<Post> posts = this.postRepository.findAll();
    List<Post> post = this.postRepository.findByCommentsPostPostId(id);
    return post;
  }
  
  public List<Post> getinfo()
  {
    List<Post> posts = postRepository.findAll();
    int size=posts.size();
    for(int i=0; i<=size; i++){
    List<Comment> comments=posts.get(i).getComments();
    }
    return posts;
  }
  
  public List<Post> getCustom(Long id)
  {
    List<Post> posts = this.postRepository.findByCommentsPostPostId(id);
    return posts;
  }
  
  public Post create(Post post)
  {
    Date now = new Date();
    post.setPostDate(now);
    post.setPostDateUp(now);
    this.postRepository.save(post);
    return post;
  }
  
  public Post update(Post post, Long id)
  {
    Post posts = (Post)this.postRepository.findOne(id);
    post.setPostId(id);
    Date now = new Date();
    post.setPostDate(posts.getPostDate());
    post.setPostDateUp(now);
    this.postRepository.save(post);
    return post;
  }
  
  public Post delete(Long id)
  {
    Post post = (Post)this.postRepository.findOne(id);
    this.postRepository.delete(post);
    return post;
  }
  
  public List<Post> searchTc(String title, String content)
  {
    List<Post> post = this.postRepository.findByPostTitleContainingOrPostContentContaining(title, content);
    return post;
  }
}
