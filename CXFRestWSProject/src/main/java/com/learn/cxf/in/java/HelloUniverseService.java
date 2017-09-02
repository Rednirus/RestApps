package com.learn.cxf.in.java;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
@Path("/hello-universe")
public interface HelloUniverseService {

		@GET
	    @Path("/echo/{input}")
	    @Produces("text/plain")
	    public String ping(@PathParam("input") String input);
}
