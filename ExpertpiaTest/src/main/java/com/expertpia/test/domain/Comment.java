package com.expertpia.test.domain;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;



//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="commentId")
@Entity
@Table(name="test_comments")
public class Comment{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "comment_id")
	private Long commentId;
	
	@ManyToOne
//	@JsonManagedReference
	@JoinColumn(name="post_id")
	private Post post;

	@ManyToOne
//	@JsonManagedReference
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name = "comment_content")
	private String commentContent;
	@Temporal(TIMESTAMP)
	@Column(name = "comment_date")
	private Date commentDate;
	@Column(name = "comment_agree")
	private Long agree;
	@Column(name = "comment_disagree")
	private Long commentDisagree;

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public Long getAgree() {
		return agree;
	}

	public void setAgree(Long agree) {
		this.agree = agree;
	}

	public Long getCommentDisagree() {
		return commentDisagree;
	}

	public void setCommentDisagree(Long commentDisagree) {
		this.commentDisagree = commentDisagree;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

//	@Override
//	public String toString() {
//		return "Comment [commentId=" 
//				+ commentId 
//				+ ", commentContent=" 
//				+ commentContent 
//				+ "]";
//	}

}
