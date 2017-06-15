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

import com.expertpia.test.domain.Category;
import com.expertpia.test.service.CategoryService;

@Path("/category")
public class CategoryResource {
	@Autowired
	private CategoryService categoryService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON+ ";charset=utf-8")
	@Path("/list")
	public Response list() {
		List<Category> cateList=categoryService.getlist();
		return Response.ok(cateList).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON+ ";charset=utf-8")
	@Path("/list/{category_id}")
	public Response getCateInfo(@PathParam("category_id") long id) {
		Category cateInfo=categoryService.getCategory(id);
		return Response.ok(cateInfo).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create")
	public Response insert(Category category) {
		categoryService.create(category);
		return Response.ok(category).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update/{category_id}")
	public Response modify(Category category, @PathParam("category_id") long id) {
		Category cateInfo=categoryService.update(id ,category);
		return Response.ok(cateInfo).build();
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete/{category_id}")
	public Response delete(@PathParam("category_id") long id) {
		Category cateInfo=categoryService.delete(id);
		return Response.ok(cateInfo).build();
	}
}
