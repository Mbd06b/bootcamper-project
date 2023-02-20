package com.organization.mvcproject.pom.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MGLMainNavMenu {
	
	WebDriver driver;
	
	//Constructor that will be automatically called as soon as the object of the class is created
	public MGLMainNavMenu(WebDriver driver) {
		this.driver=driver;
	}
	
	//Locator for GamesLnk
	By GamesNavLink = By.linkText("Games");
	By ReviewNavLink = By.linkText("Review");
	
	//Method to click gamesLink
	public void clickGames() {
		driver.findElement(GamesNavLink).click();
	}
	
	
	public void clickReview() {
		driver.findElement(ReviewNavLink).click();
	}

}
