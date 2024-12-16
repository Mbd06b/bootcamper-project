package com.organization.mvcproject.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.organization.mvcproject.pom.games.GamesPage;

@SpringJUnitConfig(classes = {WebDriverConfig.class, E2ETestContext.class})
class E2ESetupTest {

	@Autowired
	private WebDriver driver;
	
    @Autowired
    private GamesPage gamesPage;
    
    @Autowired
    private ApplicationContext context;

	@Test
	void e2eBrowserDriverIsFunctioning() {
		// Exercise
		driver.get("https://www.selenium.dev");
		String title = driver.getTitle();

		// Verify
		assertTrue(title.contains("Selenium"));
	}

    @Test
    public void testGamesPageInitializesInE2E() {
        assertNotNull(gamesPage, "GamesPage bean should be initialized by Spring");
    }

//    @Test
//    public void testGamesPageBeanExistsInE2E() {
//        assertNotNull(context.getBean(GamesPage.class), "GamesPage bean should exist in the context");
//    }
}
