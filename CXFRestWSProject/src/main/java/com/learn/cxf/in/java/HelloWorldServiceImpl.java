package com.learn.cxf.in.java;

import javax.ws.rs.core.Response;

public class HelloWorldServiceImpl implements HelloWorldService{

	@Override
	public String ping(String input) {
		return "Hello from World: "+input;
	}

	@Override
	public Response modifyJson(JsonBean input) {
		input.setVal2(input.getVal1());
        return Response.ok().entity(input).build();
	}

}
