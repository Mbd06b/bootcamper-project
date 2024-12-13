package com.organization.mvcproject.app.config;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class ServerContextConfig {
	
	  private static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	    
	    @Value("${app.server.protocol:http}")
	    private String serverProtocol;
	    
	    
	    @Value("${app.server.host:localhost}")
	    private String serverHost;

	    @Value("${app.server.port:8080}")  // Default to 8080 if not specified
	    private int serverPort;


	    @Bean
	    String baseUrl() {
	        String url = String.format("%s://%s:%d", serverProtocol, serverHost, serverPort);
	        logger.info("Configured base URL: {}", url);
	        return url;
	    }

	    @PostConstruct
	    void logConfiguration() {
	        logger.info("Server Configuration - Host: {}, Port: {}", serverHost, serverPort);
	    }

}
