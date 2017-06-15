package com.expertpia.test.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="test_users")
public class User{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "user_profile")
	private String userProfile;
	
//	@OneToMany(mappedBy="user")
//	private List<Post> posts;
//	@OneToMany(mappedBy="user")
//	private List<Comment> comments;
//	
//
//	public List<Post> getPosts() {
//		return posts;
//	}
//
//	public void setPosts(List<Post> posts) {
//		this.posts = posts;
//	}
//
//	public List<Comment> getComments() {
//		return comments;
//	}
//
//	public void setComments(List<Comment> comments) {
//		this.comments = comments;
//	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}

//	@Override
//	public String toString() {
//
//		return "User [userId=" + userId + ", userName=" + userName + ", userProfile=" + userProfile + "]";
//	}

}
