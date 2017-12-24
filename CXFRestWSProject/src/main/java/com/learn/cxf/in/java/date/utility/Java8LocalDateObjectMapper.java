package com.learn.cxf.in.java.date.utility;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.ObjectMapper;

public class Java8LocalDateObjectMapper extends ObjectMapper{
	public Java8LocalDateObjectMapper() {
		registerModule(new Java8LocalDateSimpleModule("Java8LocalDateModule", new Version(1, 1, 1, "")));
	}
	
}
