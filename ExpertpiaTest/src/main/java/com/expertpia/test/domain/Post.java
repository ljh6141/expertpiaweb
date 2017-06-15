package com.expertpia.test.domain;

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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;


//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="postId")
@Entity
@Table(name="test_posts")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "post_id")
	private Long postId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
//	@ManyToOne
//	@JoinColumn(name="comment_id")
//	private Comment comment;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	@OneToMany(mappedBy="post")
	@JsonBackReference
	private List<Comment> comments;
	
	@Column(name = "post_title")
	private String postTitle;
	
	@Column(name = "post_content")
	private String postContent;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
	@Column(name = "post_date")
	private Date postDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
	@Column(name = "post_dateup")
	private Date postDateUp;
	
	@Column(name = "post_clipcount")
	private Long clipCount;
	
	@Column(name = "post_badcount")
	private Long badCount;
	
	@Column(name = "post_replycount")
	private Long replyCount;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
//	public Comment getComment() {
//		return comment;
//	}
//
//	public void setComment(Comment comment) {
//		this.comment = comment;
//	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public Date getPostDate() {
		return postDate;
	}
	
	@PrePersist
	public void  setPostDate() {
		postDate = new Date();
	}
	
	public Date getPostDateUp() {
		return postDateUp;
	}
	
	@PreUpdate
	public void setPostDateUp() {
		postDateUp = new Date();
	}

	public Long getClipCount() {
		return clipCount;
	}

	public void setClipCount(Long clipCount) {
		this.clipCount = clipCount;
	}

	public Long getBadCount() {
		return badCount;
	}

	public void setBadCount(Long badCount) {
		this.badCount = badCount;
	}

	public Long getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(Long replyCount) {
		this.replyCount = replyCount;
	}

//	@Override
//	public String toString() {
//		
//		return "Post [postId=" 
//		+ postId 
//		+ ", postTitle=" 
//		+ postTitle 
//		+ ", postContent=" 
//		+ postContent
//		+ ", postDate=" 
//		+ postDate
//		+ ", clipCount=" 
//		+ clipCount
//		+ ", badCount=" 
//		+ badCount
//		+ ", replyCount=" 
//		+ replyCount
//		+ "]";
//	}
	
}
