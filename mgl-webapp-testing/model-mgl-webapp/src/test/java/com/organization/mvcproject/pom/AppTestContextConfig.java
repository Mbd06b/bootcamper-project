package com.organization.mvcproject.pom;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppTestContextConfig {
	
	  private static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	    
	    @Value("${test.server.protocol:http}")
	    private String serverProtocol;
	    
		@Value("${test.server.host:localhost}")
	    private String serverHost;

	    @Value("${test.server.port:8080}")  // Default to 8080 if not specified
	    private int serverPort;


	    @Bean
	    String baseUrl() {
	        String url = String.format("%s://%s:%d", serverProtocol, serverHost, serverPort);
	        logger.info("Configured base URL: {}", url);
	        return url;
	    }
	   
}
