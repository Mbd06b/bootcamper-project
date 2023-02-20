package com.organization.mvcproject.pom.games;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.organization.mvcproject.pom.common.MGLMainNavMenu;

public class GamesPage {
	
	WebDriver driver;
	
	public MGLMainNavMenu mainNavMenu;
	
    private WebElement gamesTable = driver.findElement(By.id("tableBody_ofGames"));
	private List<WebElement> gameElements = gamesTable.findElements(By.tagName("tr")); 

	
	//Locator for Interactive page elements. 
	By AddGamesButton = By.id("Games");
	By UpdateGamesButton = By.id("Review");
	By SelectGamesButton= By.id("Select");
	By DeleteGamesButton = By.id("");
	
	
	//Constructor that will be automatically called as soon as the object of the class is created
	public GamesPage(WebDriver driver) {
		this.driver = driver;
		this.mainNavMenu = new MGLMainNavMenu(this.driver); 
	}
	
	
	//Method to click gamesLink
	public void clickAdd() {
		driver.findElement(AddGamesButton).click();
	}
	
	public void clickUpdate() {
		driver.findElement(UpdateGamesButton).click();
	}
	
	public void selectGame(String id) {
		driver.findElement(UpdateGamesButton).click();
	}
	
	public void deleteGame(String id) {
		driver.findElement(UpdateGamesButton).click();
	}


	public List<WebElement> getGames() {
		return gameElements;
	}


	
}
