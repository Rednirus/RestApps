package com.learn.cxf.in.java;

public class HelloUniverseServiceImpl implements HelloUniverseService{

	@Override
	public String ping(String input) {
		return "Hello from Universe: "+input;
	}

}
