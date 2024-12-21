package com.organization.mvcproject.pom.common;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import com.organization.mvcproject.pom.annotation.PageObjectModel;


@PageObjectModel
public class BasePage {
	
    protected WebDriver driver;
    
    protected WebDriverWait wait;
    
    @Autowired
    protected String baseUrl; 
    
    private static final Duration TIMEOUT = Duration.ofSeconds(10);

	@Autowired
    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIMEOUT);
    }
	
    protected WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementToDisappear(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected void selectByVisibleText(WebElement element, String text) {
        Select select = new Select(waitForElementToBeVisible(element));
        select.selectByVisibleText(text);
    }

    protected void selectByValue(WebElement element, String value) {
        Select select = new Select(waitForElementToBeVisible(element));
        select.selectByValue(value);
    }

    protected String getSelectedOption(WebElement element) {
        Select select = new Select(waitForElementToBeVisible(element));
        return select.getFirstSelectedOption().getText();
    }

    protected void waitForTextToBePresentInElement(WebElement element, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }
}