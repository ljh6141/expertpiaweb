package com.expertpia.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expertpia.test.domain.Comment;
import com.expertpia.test.domain.Post;
import com.expertpia.test.repository.CommentRepository;
import com.expertpia.test.repository.PostRepository;


@Transactional
@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private CommentRepository commentRepository;
	
	public List<Post> getlist(){
		return postRepository.findAll();
	}
	public Post getPostInfo(Long id){
		Post posts=postRepository.findOne(id);
		return posts;
	}
	public List<Comment> getCommentInfo(Post post){
		List<Comment> comments=commentRepository.findByPost(post);
		return comments;
	}
	public Post create(Post post){
		postRepository.save(post);
		return post;
	}
	public Post update(Post post, Long id){
		post.setPostId(id);
		postRepository.save(post);
		return post;
	}
	public Post delete(Long id){
		Post post=postRepository.findOne(id);
		postRepository.delete(post);
		return post;
	}
//	public List<Post> searchTitle(String title){
//		List<Post> post=postRepository.findByPostTitleContaining(title);
//		return post;
//	}
	public List<Post> searchTc(String title, String content){
		List<Post> post=postRepository.findByPostTitleContainingOrPostContentContaining(title, content);
		return post;
	}
}
