package com.organization.mvcproject.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.organization.mvcproject.pom.POMContextConfig;
import com.organization.mvcproject.pom.common.BasePage;
import com.organization.mvcproject.pom.games.GamesPage;

@SpringJUnitConfig(classes = {POMContextConfig.class, WebDriverConfig.class})
@TestInstance(Lifecycle.PER_CLASS)
class BrowserSetupTest {

	@Autowired
	private WebDriver driver;
	
    @Autowired
    public BasePage basePage;
    
    @Autowired
    public GamesPage gamesPage; 

    @Autowired
    private ApplicationContext context;
    
    @AfterAll
    public  void cleanup() {
        if (driver != null) {
            driver.quit();
        }
    }
    
	@Test
	void browserDriverIsFunctioning() {
		driver.get("https://www.selenium.dev");
		String title = driver.getTitle();
		assertTrue(title.contains("Selenium"));
	}
	
	@Test
	void basePageInitializesWithDriver() {
		assertNotNull(basePage);
	}
	
    @Test
    public void testGamesPageInitialization() {
        assertNotNull(gamesPage, "GamesPage bean should be initialized by Spring");
    }

    @Test
    public void testGamesPageBeanExists() {
        assertNotNull(context.getBean(GamesPage.class), "GamesPage bean should exist in the context");
    }
}
