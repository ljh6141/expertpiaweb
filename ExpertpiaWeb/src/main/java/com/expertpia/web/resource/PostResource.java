package com.expertpia.web.resource;

import java.util.List;

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

import com.expertpia.web.domains.Post;
import com.expertpia.web.services.PostService;

@Path("/post")
public class PostResource
{
  @Autowired
  private PostService postService;
  
  @GET
  @Produces({"application/json;charset=utf-8"})
  @Path("/list")
  public Response list()
  {
    List<Post> postList = this.postService.getlist();
    return Response.ok(postList).build();
  }
  
  @GET
  @Produces({"application/json;charset=utf-8"})
  @Path("/list/{post_id}")
  public Response getPostInfo(@PathParam("post_id") long id)
  {
    return Response.ok(this.postService.getPostInfo(Long.valueOf(id))).build();
  }
  
  @POST
  @Consumes({"application/json"})
  @Produces({"application/json"})
  @Path("/create")
  public Response insert(Post post)
  {
    this.postService.create(post);
    return Response.ok(post).build();
  }
  
  @PUT
  @Produces({"application/json"})
  @Path("/update/{post_id}")
  public Response modify(Post post, @PathParam("post_id") long id)
  {
    Post postInfo = this.postService.update(post, Long.valueOf(id));
    return Response.ok(postInfo).build();
  }
  
  @DELETE
  @Produces({"application/json"})
  @Path("/delete/{post_id}")
  public Response delete(@PathParam("post_id") long id)
  {
    Post postInfo = this.postService.delete(Long.valueOf(id));
    return Response.ok(postInfo).build();
  }
  
  @GET
  @Produces({"application/json"})
  @Path("/search/{tc}")
  public Response searchTc(@PathParam("tc") String title, @PathParam("tc") String content)
  {
    List<Post> postInfo = this.postService.searchTc(title, content);
    return Response.ok(postInfo).build();
  }
}
