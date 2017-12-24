package com.learn.cxf.in.java.date.utility;

import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;

public class Java8LocalDateJacksonJaxbJsonProvider extends JacksonJaxbJsonProvider{

	public Java8LocalDateJacksonJaxbJsonProvider() {
		super(new Java8LocalDateObjectMapper(), DEFAULT_ANNOTATIONS);
	}
}