package com.learn.cxf.in.java;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.learn.cxf.in.java.HelloWorldService;

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
}
