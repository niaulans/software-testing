package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage extends BasePage {
    
    // Locators
    private By searchResults = By.xpath("//div[@class='g']");
    private By searchBox = By.name("q");
    private By resultStats = By.id("result-stats");
    private By searchResultLinks = By.xpath("//div[@class='g']//h3/parent::a");
    private By nextButton = By.id("pnnext");
    private By previousButton = By.id("pnprev");
    private By googleLogo = By.xpath("//a[@aria-label='Go to Google Home']");
    
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }
    
    public boolean areSearchResultsDisplayed() {
        waitForElementVisible(searchResults);
        return isElementDisplayed(searchResults);
    }
    
    public int getSearchResultCount() {
        List<WebElement> results = driver.findElements(searchResults);
        return results.size();
    }
    
    public String getFirstSearchResultTitle() {
        WebElement firstResult = driver.findElements(searchResults).get(0);
        return firstResult.findElement(By.tagName("h3")).getText();
    }
    
    public boolean isResultStatsDisplayed() {
        return isElementDisplayed(resultStats);
    }
    
    public String getResultStats() {
        return getText(resultStats);
    }
    
    public boolean isNextButtonDisplayed() {
        return isElementDisplayed(nextButton);
    }
    
    public boolean isPreviousButtonDisplayed() {
        return isElementDisplayed(previousButton);
    }
    
    public void clickNextButton() {
        click(nextButton);
    }
    
    public void clickPreviousButton() {
        click(previousButton);
    }
    
    public HomePage clickGoogleLogo() {
        click(googleLogo);
        return new HomePage(driver);
    }
    
    public SearchResultsPage performNewSearch(String searchTerm) {
        sendKeys(searchBox, searchTerm);
        driver.findElement(searchBox).submit();
        return new SearchResultsPage(driver);
    }
    
    public void clickFirstSearchResult() {
        WebElement firstResult = driver.findElements(searchResultLinks).get(0);
        firstResult.click();
    }
}