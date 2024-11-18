package com.organization.mvcproject.app.config;

import java.lang.invoke.MethodHandles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

import com.organization.mvcproject.test.WebDriverConfig;

import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import jakarta.annotation.PostConstruct;

//@SpringJUnitConfig(classes = MGLWebApplicationInitializer.class )
@Configuration
@CucumberContextConfiguration
@ContextConfiguration(classes = MvcConfiguration.class)
@Import(WebDriverConfig.class)
public class SpringContextConfiguration {
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

    @Before
    void contextLoads() {
        logger.info("----------------- Spring Context Initialized for Executing Cucumber Tests ------------------");
    }
    
}
