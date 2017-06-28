package com.expertpia.web.domains;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="test_posts")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Post
{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="post_id")
  private Long postId;
  @ManyToOne
  @JoinColumn(name="user_id")
  private User user;
  @ManyToOne
  @JoinColumn(name="interest_id")
  private Interest interest;
  @OneToMany(mappedBy="post")
  @JsonBackReference
  private List<Comment> comments;
  @Column(name="post_title")
  private String postTitle;
  @Column(name="post_content")
  private String postContent;
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm", timezone="Asia/Seoul")
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="post_date")
  private Date postDate;
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm", timezone="Asia/Seoul")
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="post_dateup")
  private Date postDateUp;
  @Column(name="post_clipcount")
  private Long clipCount;
  @Column(name="post_badcount")
  private Long badCount;
  @Column(name="post_replycount")
  private Long replyCount;
  
  public Post()
  {
    this.comments = new ArrayList();
  }
  
  public Post(String content, List<Comment> comments)
  {
    this.postContent = content;
    this.comments = comments;
  }
  
  public void addComment(Comment comment)
  {
    this.comments.add(comment);
    if (comment.getPost() != this) {
      comment.setPost(this);
    }
  }
  
  public User getUser()
  {
    return this.user;
  }
  
  public void setUser(User user)
  {
    this.user = user;
  }
  
  public List<Comment> getComments()
  {
    return this.comments;
  }
  
  public Interest getInterest()
  {
    return this.interest;
  }
  
  public void setInterest(Interest interest)
  {
    this.interest = interest;
  }
  
  public void setComments(List<Comment> comments)
  {
    this.comments = comments;
  }
  
  public Long getPostId()
  {
    return this.postId;
  }
  
  public void setPostId(Long postId)
  {
    this.postId = postId;
  }
  
  public String getPostTitle()
  {
    return this.postTitle;
  }
  
  public void setPostTitle(String postTitle)
  {
    this.postTitle = postTitle;
  }
  
  public String getPostContent()
  {
    return this.postContent;
  }
  
  public void setPostContent(String postContent)
  {
    this.postContent = postContent;
  }
  
  public Date getPostDate()
  {
    return this.postDate;
  }
  
  public void setPostDate(Date postDate)
  {
    this.postDate = postDate;
  }
  
  public Date getPostDateUp()
  {
    return this.postDateUp;
  }
  
  public void setPostDateUp(Date postDateUp)
  {
    this.postDateUp = postDateUp;
  }
  
  public Long getClipCount()
  {
    return this.clipCount;
  }
  
  public void setClipCount(Long clipCount)
  {
    this.clipCount = clipCount;
  }
  
  public Long getBadCount()
  {
    return this.badCount;
  }
  
  public void setBadCount(Long badCount)
  {
    this.badCount = badCount;
  }
  
  public Long getReplyCount()
  {
    return this.replyCount;
  }
  
  public void setReplyCount(Long replyCount)
  {
    this.replyCount = replyCount;
  }
  
  public String toString()
  {
    return 
    
      "Post [postId=" + this.postId + ", user=" + this.user + ", interest=" + this.interest + ", comments=" + this.comments + ", postTitle=" + this.postTitle + ", postContent=" + this.postContent + ", postDate=" + this.postDate + ", postDateUp=" + this.postDateUp + ", clipCount=" + this.clipCount + ", badCount=" + this.badCount + ", replyCount=" + this.replyCount + "]";
  }
}
