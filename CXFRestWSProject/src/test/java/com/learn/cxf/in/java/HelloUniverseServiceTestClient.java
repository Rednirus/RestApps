package com.learn.cxf.in.java;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.learn.cxf.in.java.HelloUniverseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/hello-universe-service-client.xml"})
public class HelloUniverseServiceTestClient {
	@Autowired
	private HelloUniverseService helloUniverseService;
	
	@Test
	public void test(){
		String s = helloUniverseService.ping("Suri");
		System.out.println(" "+s);
	}
}
