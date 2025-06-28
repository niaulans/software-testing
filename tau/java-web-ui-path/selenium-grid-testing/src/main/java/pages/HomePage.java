package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    
    // Locators
    private By searchBox = By.name("q");
    private By searchButton = By.name("btnK");
    private By feelingLuckyButton = By.name("btnI");
    private By googleLogo = By.xpath("//img[@alt='Google']");
    private By languageLinks = By.xpath("//div[@id='SIvCob']//a");
    
    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    public void navigateToHomePage() {
        driver.get("https://www.google.com");
    }
    
    public void enterSearchTerm(String searchTerm) {
        sendKeys(searchBox, searchTerm);
    }
    
    public void clickSearchButton() {
        click(searchButton);
    }
    
    public void clickFeelingLuckyButton() {
        click(feelingLuckyButton);
    }
    
    public boolean isLogoDisplayed() {
        return isElementDisplayed(googleLogo);
    }
    
    public boolean isSearchBoxDisplayed() {
        return isElementDisplayed(searchBox);
    }
    
    public boolean isSearchButtonDisplayed() {
        return isElementDisplayed(searchButton);
    }
    
    public boolean isFeelingLuckyButtonDisplayed() {
        return isElementDisplayed(feelingLuckyButton);
    }
    
    public SearchResultsPage performSearch(String searchTerm) {
        enterSearchTerm(searchTerm);
        clickSearchButton();
        return new SearchResultsPage(driver);
    }
    
    public boolean areLanguageLinksDisplayed() {
        return isElementDisplayed(languageLinks);
    }
}