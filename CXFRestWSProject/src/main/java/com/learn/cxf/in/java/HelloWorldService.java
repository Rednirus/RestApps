package com.learn.cxf.in.java;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/hello-world")
public interface HelloWorldService {

	@GET
    @Path("/echo/{input}")
    @Produces("text/plain")
    public String ping(@PathParam("input") String input);

	@POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/jsonBean")
    public Response modifyJson(JsonBean input) ;
}

