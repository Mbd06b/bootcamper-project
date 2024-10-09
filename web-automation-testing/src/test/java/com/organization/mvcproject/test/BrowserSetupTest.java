package com.organization.mvcproject.test;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BrowserSetupTest{

	
	  WebDriver driver;

	    @BeforeAll
	    static void setupClass() {
	        WebDriverManager.chromedriver().setup();
	    }

	    @BeforeEach
	    void setupTest() {
	        driver = new ChromeDriver();
	    }

	    @AfterEach
	    void teardown() {
	        driver.quit();
	    }

	    @Test
	    void browserDriverIsFunctioning() {
	        // Exercise
	        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
	        String title = driver.getTitle();
	        
	        // Verify
	        assertTrue(title.contains("Selenium WebDriver"));
	    }
}
