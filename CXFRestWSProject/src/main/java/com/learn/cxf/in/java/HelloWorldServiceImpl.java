package com.learn.cxf.in.java;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HelloWorldServiceImpl implements HelloWorldService{

	@Override
	public String ping(String input) {
		return "Hello from World: "+input;
	}

	@Override
	public String getCurrentTime(LocalDateTime currentTime) {
		return currentTime.format(DateTimeFormatter.ofPattern("dd/mm/yyyy HH MM ss"));
	}



}
