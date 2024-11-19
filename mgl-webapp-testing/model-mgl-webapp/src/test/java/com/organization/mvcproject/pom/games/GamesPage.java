package com.organization.mvcproject.pom.games;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.organization.mvcproject.pom.annotation.PageObjectModel;
import com.organization.mvcproject.pom.common.BasePage;
import com.organization.mvcproject.pom.common.MGLMainNavMenu;

@PageObjectModel
public class GamesPage extends BasePage {
    
	@Autowired
    private MGLMainNavMenu mainNavMenu;
    
    @Autowired
    public GamesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Form Elements
    @FindBy(id = "game_name")
    private WebElement gameNameInput;

    @FindBy(id = "game_genre")
    private WebElement gameGenreInput;

    // Buttons in the form
    @FindBy(css = "input[value='Add']")
    private WebElement addButton;

    @FindBy(css = "button[type='submit']")
    private WebElement updateButton;

    @FindBy(css = "button[type='reset']")
    private WebElement clearButton;

    // Genre Filter
    @FindBy(id = "select_genre_filter")
    private WebElement genreFilterDropdown;

    // Table Elements
    @FindBy(id = "tableBody_ofGames")
    private WebElement gamesTableBody;

    @FindBy(xpath = "//tbody[@id='tableBody_ofGames']/tr")
    private List<WebElement> gameRows;

    // Form Actions
    public void enterGameName(String name) {
        waitForElementToBeVisible(gameNameInput).clear();
        gameNameInput.sendKeys(name);
    }

    public void enterGameGenre(String genre) {
        waitForElementToBeVisible(gameGenreInput).clear();
        gameGenreInput.sendKeys(genre);
    }

    public void clickAdd() {
        waitForElementToBeClickable(addButton).click();
    }

    public void clickUpdate() {
        waitForElementToBeClickable(updateButton).click();
    }

    public void clickClear() {
        waitForElementToBeClickable(clearButton).click();
    }

    // Filter Actions
    public void selectGenreFilter(String genre) {
        waitForElementToBeVisible(genreFilterDropdown).click();
        // Using a helper method from BasePage to select option by visible text
        selectByVisibleText(genreFilterDropdown, genre);
    }

    // Table Actions
    public void selectGame(String gameName) {
        WebElement row = findGameRowByName(gameName);
        if (row != null) {
            WebElement selectButton = row.findElement(By.cssSelector("button[data-ng-click*='updateGame']"));
            waitForElementToBeClickable(selectButton).click();
        } else {
            throw new RuntimeException("Game with name '" + gameName + "' not found");
        }
    }

    public void deleteGame(String gameName) {
        WebElement row = findGameRowByName(gameName);
        if (row != null) {
            WebElement deleteButton = row.findElement(By.cssSelector("button[data-ng-click*='deleteGame']"));
            waitForElementToBeClickable(deleteButton).click();
        } else {
            throw new RuntimeException("Game with name '" + gameName + "' not found");
        }
    }

    public void clickGameLink(String gameName) {
        WebElement row = findGameRowByName(gameName);
        if (row != null) {
            WebElement link = row.findElement(By.tagName("a"));
            waitForElementToBeClickable(link).click();
        }
    }

    // Helper Methods
    private WebElement findGameRowByName(String gameName) {
        return gameRows.stream()
            .filter(row -> {
                WebElement nameElement = row.findElement(By.xpath(".//td[1]/a/span"));
                return nameElement.getText().equals(gameName);
            })
            .findFirst()
            .orElse(null);
    }

    public String getGameGenre(String gameName) {
        WebElement row = findGameRowByName(gameName);
        if (row != null) {
            return row.findElement(By.xpath(".//td[2]/span")).getText();
        }
        return null;
    }

    public boolean isGamePresent(String gameName) {
        return findGameRowByName(gameName) != null;
    }

    public int getGamesCount() {
        return gameRows.size();
    }

    public List<String> getAllGameNames() {
        return gameRows.stream()
            .map(row -> row.findElement(By.xpath(".//td[1]/a/span")).getText())
            .toList();
    }

    // Form validation methods
    public boolean isNameErrorVisible() {
        return driver.findElement(By.cssSelector(".has-error")).isDisplayed();
    }

    public String getNameErrorMessage() {
        return driver.findElement(By.cssSelector(".has-error")).getText();
    }
}
