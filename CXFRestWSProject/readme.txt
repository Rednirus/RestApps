This project is to learn building JAX-RS Webservices using CXF on tomcat server. I have used a tech blog http://www.learninjava.com/pages/restful-webservice-using-cxf.php as reference to build this project. I  have modified it to use clients for using REST services  running on cxf server. Steps are very simple.

To run this project:
go to pom.xml path and run below command
1. build and run : mvn clean package -DskipTests=true tomcat7:run
2. build and package
	a. delete and package again -> mvn clean package -DskipTests
	b. run tomcat- > mvn tomcat7:run -DskipTests

Details :

Basic steps are very clearly mentioned in linkk above.
CXFServlet set up in web.xml listens to incoming requests and forwards those requests rest service deployed on server.
beans.xml contains <server> tag to lists services which should be exposed as rest services.

<jaxrs:server id="services" address="/hello-world-service">
        <jaxrs:serviceBeans>
            <bean class="com.learn.cxf.in.java.HelloWorldServiceImpl"/>
        </jaxrs:serviceBeans>
        <jaxrs:providers>
            <bean class="org.codehaus.jackson.jaxrs.JacksonJsonProvider"/>
        </jaxrs:providers>
    </jaxrs:server>
    
    <jaxrs:server id="services1" address="/hello-universe-service">
        <jaxrs:serviceBeans>
            <bean class="com.learn.cxf.in.java.HelloUniverseServiceImpl"/>
        </jaxrs:serviceBeans>
        <jaxrs:providers>
            <bean class="org.codehaus.jackson.jaxrs.JacksonJsonProvider"/>
        </jaxrs:providers>
    </jaxrs:server>	
	
	Here, HelloWorldServiceImpl can be accessed using url : http://localhost:9090/cxf-rs-services/hello-world-service/hello-world/echo/yourName
		a. http://localhost:9090/ -> tomcat server address
		b. cxf-rs-services -> our services context root address, it is mentioned in pom.xl
		c. hello-world-service -> this is address to access HelloWorldService service, and mentioned in <server> tag in beans.xml
		d. hello-world/echo/yourName-> REST resources in HelloWorldService.
	HelloUniverseServiceImpl can be access using /hello-universe-service in beans.xml <server> tag. 
	
	We could use common address to access both services entioned above. To use that, beans.xml would look like this
	<jaxrs:server id="services" address="/hello-common-service">
        <jaxrs:serviceBeans>
            <bean class="com.learn.cxf.in.java.HelloWorldServiceImpl"/>
			<bean class="com.learn.cxf.in.java.HelloUniverseServiceImpl"/>
        </jaxrs:serviceBeans>
        <jaxrs:providers>
            <bean class="org.codehaus.jackson.jaxrs.JacksonJsonProvider"/>
        </jaxrs:providers>
    </jaxrs:server>

	Now, the URL will change like below:
	http://localhost:9090/cxf-rs-services/hello-common-service/hello-world/echo/yourName-> HelloWorldService
	http://localhost:9090/cxf-rs-services/hello-common-service/hello-universe/echo/yourName-> HelloUniverseService
	
	
	Now to access these services from other application, lets say client application, we use htt: conduit to open http connection between client and server, 
	1. it contains conduit name which is REST interface which is exposed as webservice on server side
	2. timeout parameters
	3. address to this service and providers which are used to help transfer data properly. Like JacksonJsonProvider is used for JSON conversion of data which is returned from this service.
	
	<http-conf:conduit name=".*HelloWorldService.*">
		<http-conf:client ReceiveTimeout="300000"/>
	</http-conf:conduit>
	
	
	<jaxrs-client:client id="helloWorldService" address="http://localhost:9090/cxf-rs-services/hello-world-service"
				  serviceClass="com.learn.cxf.in.java.HelloWorldService">
		<jaxrs-client:providers>
			<bean class="org.codehaus.jackson.jaxrs.JacksonJsonProvider"/>
		</jaxrs-client:providers>
	</jaxrs-client:client>
	
	
	
	If you have any, queries, please write to rednirus@gmail.com
	
	Thanks