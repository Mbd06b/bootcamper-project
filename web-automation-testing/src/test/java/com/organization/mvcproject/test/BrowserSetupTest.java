package com.organization.mvcproject.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(WebDriverConfig.class)
class BrowserSetupTest {

	@Autowired
	private WebDriver driver;

	@Test
	void browserDriverIsFunctioning() {
		// Exercise
		driver.get("https://www.selenium.dev");
		String title = driver.getTitle();

		// Verify
		assertTrue(title.contains("Selenium"));
	}
}
