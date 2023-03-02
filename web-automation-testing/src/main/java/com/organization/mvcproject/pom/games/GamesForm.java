package com.organization.mvcproject.pom.games;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GamesForm {
	
	@FindBy(id = "game_name")
	WebElement gameNameField; 
	
	@FindBy(id = "game_name")
	WebElement gameGenreField; 
	
	

}
