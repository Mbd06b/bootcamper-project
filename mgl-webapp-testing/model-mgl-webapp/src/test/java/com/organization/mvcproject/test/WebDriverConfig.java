package com.organization.mvcproject.test;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

@Configuration
public class WebDriverConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(WebDriverConfig.class);
    
    @Value("${selenium.headless:false}") 
    private boolean headless;
    
    @Bean
    public ChromeOptions chromeOptions() {
        logger.info("Creating chromeOptions Bean from model module.");
        ChromeOptions options = new ChromeOptions();
        if (headless) {
            options.addArguments("--headless");
        }
        // Add any other desired Chrome options
        options.addArguments("--start-maximized");
        return options;
    }
    
    @Bean(destroyMethod = "quit")
    public WebDriver webDriver(ChromeOptions options) {
    	logger.info("Creating WebDriver Bean from model module w/ options: {}", options);
        return new ChromeDriver(options);
    }
    
	@Bean
	ApplicationListener<ContextRefreshedEvent> init() {
	    return event -> {
	        logger.info("Beans in context in e2e module:");
	        Arrays.stream(event.getApplicationContext()
	        	  .getBeanDefinitionNames())
	              .forEach(logger::debug);
	    };
	}
}
