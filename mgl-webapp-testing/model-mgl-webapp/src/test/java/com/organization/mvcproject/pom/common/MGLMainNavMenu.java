package com.organization.mvcproject.pom.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.organization.mvcproject.pom.annotation.PageObjectModel;

@PageObjectModel
public class MGLMainNavMenu extends BasePage {

	
    @FindBy(linkText = "Games")  // Using exact link text instead of ID
    private WebElement gamesLink;
    
    @FindBy(linkText = "Review")  // Using exact link text instead of ID
    private WebElement reviewLink;
    
    @Autowired
    public MGLMainNavMenu( WebDriver driver) {
        super(driver);
     //   PageFactory.initElements(driver, this);
    }
    
    public void clickGames() {
        waitForElementToBeClickable(gamesLink).click();
    }
    
    public void clickReview() {
        waitForElementToBeClickable(reviewLink).click();
    }

}
