package com.expertpia.web.domains;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="test_comments")
public class Comment
{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="comment_id")
  private Long commentId;
  @ManyToOne
  @JoinColumn(name="post_id")
  private Post post;
  @ManyToOne
  @JoinColumn(name="user_id")
  private User user;
  @Column(name="comment_content")
  private String commentContent;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="comment_date")
  private Date commentDate;
  @Column(name="comment_agree")
  private Long agree;
  @Column(name="comment_disagree")
  private Long commentDisagree;
  
  public Comment() {}
  
  public Comment(String content)
  {
    this.commentContent = content;
  }
  
  public void setPostAndMember(Post post, User user)
  {
    this.post = post;
    this.user = user;
  }
  
  public Date getCommentDate()
  {
    return this.commentDate;
  }
  
  public void setCommentDate(Date commentDate)
  {
    this.commentDate = commentDate;
  }
  
  public Long getAgree()
  {
    return this.agree;
  }
  
  public void setAgree(Long agree)
  {
    this.agree = agree;
  }
  
  public Long getCommentDisagree()
  {
    return this.commentDisagree;
  }
  
  public void setCommentDisagree(Long commentDisagree)
  {
    this.commentDisagree = commentDisagree;
  }
  
  public Long getCommentId()
  {
    return this.commentId;
  }
  
  public void setCommentId(Long commentId)
  {
    this.commentId = commentId;
  }
  
  public Post getPost()
  {
    return this.post;
  }
  
  public void setPost(Post post)
  {
    if (this.post != null) {
      this.post.getComments().remove(this);
    }
    this.post = post;
    post.getComments().add(this);
  }
  
  public User getUser()
  {
    return this.user;
  }
  
  public void setUser(User user)
  {
    this.user = user;
  }
  
  public String getCommentContent()
  {
    return this.commentContent;
  }
  
  public void setCommentContent(String commentContent)
  {
    this.commentContent = commentContent;
  }
}
