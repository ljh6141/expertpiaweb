package com.expertpia.web.resource;

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
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.expertpia.web.domains.Comment;
import com.expertpia.web.services.CommentService;

@Transactional
@Path("/comment")
public class CommentResource
{
  @Autowired
  private CommentService commentService;
  
  @GET
  @Produces({"application/json;charset=utf-8"})
  @Path("/list")
  public Response list()
  {
    List<Comment> comment = this.commentService.getlist();
    return Response.ok(comment).build();
  }
  
  @GET
  @Produces({"application/json;charset=utf-8"})
  @Path("/list/{comment_id}")
  public Response getCommentInfo(@PathParam("comment_id") long id)
  {
    Comment comments = this.commentService.getComment(Long.valueOf(id));
    return Response.ok(comments).build();
  }
  
  @POST
  @Consumes({"application/json"})
  @Produces({"application/json"})
  @Path("/create")
  public Response insert(Comment comment)
  {
    Comment comments = this.commentService.create(comment);
    
    return Response.ok(comments).build();
  }
  
  @PUT
  @Produces({"application/json"})
  @Path("/update/{comment_id}")
  public Response modify(Comment comment, @PathParam("comment_id") long id)
  {
    Comment comments = this.commentService.update(comment, Long.valueOf(id));
    return Response.ok(comments).build();
  }
  
  @DELETE
  @Consumes({"application/json"})
  @Produces({"application/json"})
  @Path("/delete/{comment_id}")
  public Response delete(@PathParam("comment_id") long id)
  {
    Comment comments = this.commentService.delete(Long.valueOf(id));
    
    return Response.ok(comments).build();
  }
}
