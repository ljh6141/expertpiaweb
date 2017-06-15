package com.expertpia.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expertpia.test.domain.Comment;
import com.expertpia.test.domain.Post;
import com.expertpia.test.domain.User;

public interface PostRepository extends JpaRepository<Post, Long> {
	List<Post> findByUser(User user);
	Post findByComments(Comment comment);
	Post findByPostId(Long id);

//	List<Post> findByPostTitleContaining(String title);
	List<Post> findByPostTitleContainingOrPostContentContaining(String title, String content);
}
