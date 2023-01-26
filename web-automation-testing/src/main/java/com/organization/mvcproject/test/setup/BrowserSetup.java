package com.organization.mvcproject.test.setup;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BrowserSetup {

	
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
	        
	        assertTrue(title.contains("Selenium WebDriver"));
	        // Verify
	       // assertThat(title).contains("Selenium WebDriver");
	    }
}
