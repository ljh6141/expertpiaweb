package com.expertpia.test.resource;

import java.util.List;

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

import com.expertpia.test.domain.User;
import com.expertpia.test.service.UserService;


@Path("/user")
public class UserResource {
	@Autowired
	private UserService userService;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON+ ";charset=utf-8"})
	@Path("/list")
	public Response list() {
		List<User> userList=userService.getlist();
		return Response.ok(userList).build();
	}
	
	@GET
	@Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON+ ";charset=utf-8"})
	@Path("/list/{user_id}")
	public Response getUserInfo(@PathParam("user_id") long id) {
		User userInfo=userService.getUser(id);
		return Response.ok(userInfo).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create")
	public Response insert(User user) {
		userService.create(user);
		return Response.ok(user).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update/{user_id}")
	public Response modify(User user, @PathParam("user_id") long id) {
		User userInfo=userService.update(user, id);
		return Response.ok(userInfo).build();
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete/{user_id}")
	public Response delete(@PathParam("user_id") long id) {
		userService.delete(id);
		return Response.ok().build();
	}
}
