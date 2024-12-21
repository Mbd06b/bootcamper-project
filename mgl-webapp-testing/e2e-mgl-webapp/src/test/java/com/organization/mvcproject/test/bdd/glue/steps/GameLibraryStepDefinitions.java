package com.organization.mvcproject.test.bdd.glue.steps;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import com.organization.mvcproject.pom.common.MGLMainNavMenu;
import com.organization.mvcproject.pom.games.GamesPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//managed by cucumber
public class GameLibraryStepDefinitions {
	
	@Autowired
	private WebDriver driver;
	
	@Autowired
	private String baseUrl;
	  
	@Autowired
    private GamesPage gamesPage;
	
	@Autowired
    private MGLMainNavMenu mainNav;

    @Before("@web")
    public void setup() {
        driver.get(baseUrl);  // Handle navigation setup in @Before
    }
    
    @After("@web")
    public void cleanup() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    @When("Matthew opens his game library")
    public void matthew_opens_game_library() {
        mainNav.clickGames();
    }
    
    @Then("I should have {int} starter games.")
    public void i_should_have_starter_games(Integer expectedCount) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
        .until(webDriver -> gamesPage.getGamesCount() > 0);
        assertThat(gamesPage.getGamesCount()).isEqualTo(expectedCount);
    }

	@When("Matthew wants to add {string}")
	public void matthew_wants_to_add(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I should get {string} added to Games")
	public void i_should_get_added_to_games(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("Matthew has {string}")
	public void matthew_has(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("Matthew wants upgrade the edition name to {string}")
	public void matthew_wants_upgrade_the_edition_name_to(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("{string} should change to {string}")
	public void should_change_to(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("Matthew has {string} registered in Games")
	public void matthew_has_registered_in_games(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("Matthew deletes {string}")
	public void matthew_deletes(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Games should not contain {string}")
	public void games_should_not_contain(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
