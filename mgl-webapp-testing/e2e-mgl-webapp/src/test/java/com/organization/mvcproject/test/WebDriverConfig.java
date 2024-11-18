package com.organization.mvcproject.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebDriverConfig {
    
    @Value("${selenium.headless:false}")  // defaults to false if not specified
    private boolean headless;
    
    @Bean
    public ChromeOptions chromeOptions() {
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
        return new ChromeDriver(options);
    }
}
