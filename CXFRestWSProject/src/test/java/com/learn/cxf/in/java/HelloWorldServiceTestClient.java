package com.learn.cxf.in.java;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/hello-world-service-client.xml"})
public class HelloWorldServiceTestClient {

	@Autowired
	private HelloWorldService helloWorldService;
	
	@Test
	public void getHelloToWorld(){
		String s = helloWorldService.ping("Suri");
		System.out.println(" "+s);
	}
	
	@Test
	public void testLocalDateTime(){
		String s = helloWorldService.getCurrentTime(LocalDateTime.now());
		System.out.println(" "+s);
	}
}
