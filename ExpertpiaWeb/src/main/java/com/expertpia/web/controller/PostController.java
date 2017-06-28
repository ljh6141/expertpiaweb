package com.expertpia.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.expertpia.web.domains.Comment;
import com.expertpia.web.domains.Post;
import com.expertpia.web.repositories.CommentRepository;
import com.expertpia.web.services.CommentService;
import com.expertpia.web.services.PostService;

@RequestMapping({"/post"})
@Controller
public class PostController{
private Logger logger = LoggerFactory.getLogger(PostController.class);
  @Autowired
  private PostService postService;
  @Autowired
  private CommentService commentService;
  @Autowired
  private CommentRepository commentRepository;
  
  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Model model)
  {
	List<Post> list = this.postService.getlist2(); //글값모두 가져온다
	List<Comment> comments=postService.getCommentInfo2();
	model.addAttribute("list", list);
    int size=list.size();// 글값의 크기를잰다
//    logger.info("사이즈는: "+size);
    for(int i=0; i<size; i++){ //글값의  0부터 크기까지 1씩증가시켜서 반복한다
    	Long postId=list.get(i).getPostId(); //글값의 i번의 글아이디를 받는다
//    	logger.info("아이디는: "+postId);
    	List<Comment> comment=postService.getCommentInfo(postId); //i번의 아이디의 해당하는 댓글리스트를 불러온다
//    	logger.info("커멘트는: "+comment);
    	//이걸 모델에 어떻게 담아줌???

    	model.addAttribute("comment", comment);//이렇게 하면 여기에 담길라나?
    	 
//    	logger.info("댓글리스트: "+model.addAttribute("comment", comment));
    }
   
    return "post/list";
  }
  
  @RequestMapping(value={"/read"}, method={org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST})
  public String read(Long id, Model model)
  {
    model.addAttribute("read", this.postService.getPostInfo(id));
    model.addAttribute("comment", this.postService.getCommentInfo(id));
    return "post/view";
  }
}
