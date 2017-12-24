package com.learn.cxf.in.java;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.MappingJsonFactory;
import org.junit.Test;

import com.learn.cxf.in.java.date.utility.Java8LocalDateJacksonJaxbJsonProvider;

public class HelloWorldTest {
    private static String endpointUrl ="http://localhost:9090/cxf-rs-services/hello-universe-service";

    @Test
    public void testPing() throws Exception {
        WebClient client = WebClient.create(endpointUrl+"/hello-universe/echo/suri");
        Response r = client.accept("text/plain").get();
        assertEquals(Response.Status.OK.getStatusCode(), r.getStatus());
        String value = IOUtils.toString((InputStream)r.getEntity());
        assertEquals("Hello from Universe: suri", value);
    }

    @Test
    public void testLocalDate() throws Exception {
        List<Object> providers = new ArrayList<Object>();
        providers.add(new Java8LocalDateJacksonJaxbJsonProvider());
        WebClient client = WebClient.create(endpointUrl+"/hello-universe/getToday?today="+LocalDate.now(), providers);
        Response r = client.accept("application/json")
            .type("application/json").get();
        assertEquals(Response.Status.OK.getStatusCode(), r.getStatus());
        MappingJsonFactory factory = new MappingJsonFactory();
        JsonParser parser = factory.createJsonParser((InputStream)r.getEntity());
        LocalDate output = parser.readValueAs(LocalDate.class);
        System.out.println(output);
    }
}
