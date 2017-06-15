package com.expertpia.test.resource;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.expertpia.test.domain.Comment;
import com.expertpia.test.service.CommentService;

@Transactional
@Path("/comment")
public class CommentResource {
	@Autowired
	private CommentService commentService;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON+ ";charset=utf-8")
	@Path("/list")
	public Response list() {
		List<Comment> comment= commentService.getlist();
		return Response.ok(comment).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON+ ";charset=utf-8")
	@Path("/list/{comment_id}")
	public Response getCommentInfo(@PathParam("comment_id") long id) {
		Comment comments=commentService.getComment(id);
		return Response.ok(comments).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create")
	public Response insert(Comment comment) {
		Comment comments=commentService.create(comment);
//		Post posts=commentService.plusReplyCount(comments);
//		Comment comments=commentService.create(comment);
//		Post posts=postService.findByComments(comments);
//		posts.setReplyCount(posts.getReplyCount()+1);
//		postService.save(posts);
		return Response.ok(comments).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update/{comment_id}")
	public Response modify(Comment comment, @PathParam("comment_id") long id) {
		Comment comments=commentService.update(comment,id);
		return Response.ok(comments).build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete/{comment_id}")
	public Response delete(@PathParam("comment_id") long id) {
		Comment comments=commentService.delete(id);
//		Post posts=commentService.minusReplyCount(comments);
		return Response.ok(comments).build();
	}
}
