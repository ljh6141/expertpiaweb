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

import com.expertpia.web.domains.Interest;
import com.expertpia.web.services.InterestService;

@Path("/interest")
public class InterestResource
{
  @Autowired
  private InterestService inserestService;
  
  @GET
  @Produces({"application/json;charset=utf-8"})
  @Path("/list")
  public Response list()
  {
    List<Interest> interList = this.inserestService.getlist();
    return Response.ok(interList).build();
  }
  
  @GET
  @Produces({"application/json;charset=utf-8"})
  @Path("/list/{interest_id}")
  public Response getCateInfo(@PathParam("interest_id") long id)
  {
    Interest interInfo = this.inserestService.getInterest(Long.valueOf(id));
    return Response.ok(interInfo).build();
  }
  
  @POST
  @Consumes({"application/json"})
  @Produces({"application/json"})
  @Path("/create")
  public Response insert(Interest interest)
  {
    this.inserestService.create(interest);
    return Response.ok(interest).build();
  }
  
  @PUT
  @Produces({"application/json"})
  @Path("/update/{interest_id}")
  public Response modify(Interest interest, @PathParam("interest_id") long id)
  {
    Interest interInfo = this.inserestService.update(Long.valueOf(id), interest);
    return Response.ok(interInfo).build();
  }
  
  @DELETE
  @Produces({"application/json"})
  @Path("/delete/{interest_id}")
  public Response delete(@PathParam("interest_id") long id)
  {
    Interest interInfo = this.inserestService.delete(Long.valueOf(id));
    return Response.ok(interInfo).build();
  }
}
