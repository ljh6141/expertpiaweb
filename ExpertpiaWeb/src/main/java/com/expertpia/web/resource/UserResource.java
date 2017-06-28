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

import com.expertpia.web.domains.User;
import com.expertpia.web.services.UserService;

@Path("/user")
public class UserResource
{
  @Autowired
  private UserService userService;
  
  @GET
  @Produces({"application/json;charset=utf-8"})
  @Path("/list")
  public Response list()
  {
    List<User> userList = this.userService.getlist();
    return Response.ok(userList).build();
  }
  
  @GET
  @Produces({"text/plain", "application/json;charset=utf-8"})
  @Path("/list/{user_id}")
  public Response getUserInfo(@PathParam("user_id") long id)
  {
    User userInfo = this.userService.getUser(Long.valueOf(id));
    return Response.ok(userInfo).build();
  }
  
  @POST
  @Consumes({"application/json"})
  @Produces({"application/json"})
  @Path("/create")
  public Response insert(User user)
  {
    this.userService.create(user);
    return Response.ok(user).build();
  }
  
  @PUT
  @Produces({"application/json"})
  @Path("/update/{user_id}")
  public Response modify(User user, @PathParam("user_id") long id)
  {
    User userInfo = this.userService.update(user, Long.valueOf(id));
    return Response.ok(userInfo).build();
  }
  
  @DELETE
  @Produces({"application/json"})
  @Path("/delete/{user_id}")
  public Response delete(@PathParam("user_id") long id)
  {
    this.userService.delete(Long.valueOf(id));
    return Response.ok().build();
  }
}
