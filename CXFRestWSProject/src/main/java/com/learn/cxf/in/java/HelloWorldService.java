package com.learn.cxf.in.java;
import java.time.LocalDateTime;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/hello-world")
public interface HelloWorldService {

	@GET
    @Path("/echo/{input}")
    @Produces("text/plain")
    public String ping(@PathParam("input") String input);

	@GET
    @Consumes("application/json")
    @Path("/currentTime")
    public String getCurrentTime(@QueryParam("currentTime") LocalDateTime currentTime) ;
}

