package com.expertpia.test.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expertpia.test.domain.Comment;
import com.expertpia.test.domain.Post;
import com.expertpia.test.repository.CommentRepository;
import com.expertpia.test.repository.PostRepository;

@Transactional
@Service
public class CommentService {
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private CommentRepository commentRepository;
	
	public List<Comment> getlist(){
		return commentRepository.findAll();
	}
	public Comment getComment(Long id){
		Comment comments=commentRepository.findOne(id);
		return comments;
	}
	public Comment create(Comment comment){
		Comment comments=commentRepository.save(comment);
		Long postId=comment.getPost().getPostId();
		Post posts=postRepository.findByPostId(postId);
//		Post posts=postRepository.findByComments(comment);
		posts.setReplyCount(posts.getReplyCount()+1);
//		postRepository.save(posts);	
		return comments;
	}
	public Comment update(Comment comment, Long id){
		comment.setCommentId(id);
		commentRepository.save(comment);
		return comment;
	}
	public Comment delete(Long id){
		Comment comment=commentRepository.findOne(id);
		Long postId=comment.getPost().getPostId();
		commentRepository.delete(comment);
		Post posts=postRepository.findByPostId(postId);
		posts.setReplyCount(posts.getReplyCount()-1);
		return comment;
	}
}
