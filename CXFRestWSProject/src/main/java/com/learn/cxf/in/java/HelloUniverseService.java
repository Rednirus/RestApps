package com.learn.cxf.in.java;

import java.time.LocalDate;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
@Path("/hello-universe")
public interface HelloUniverseService {

		@GET
	    @Path("/echo/{input}")
	    @Produces("text/plain")
	    public String ping(@PathParam("input") String input);
		
		@GET
	    @Path("getToday")
		@Consumes(MediaType.APPLICATION_JSON)
	    public String getToday(@QueryParam("today") LocalDate today);
}
