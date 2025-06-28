package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
// import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingExample1Page {

    private WebDriver driver;
    private By startButton = By.cssSelector("#start button");
    private By loadingIndicator = By.id("loading");
    private By loadedtext = By.id("finish");


    public DynamicLoadingExample1Page(WebDriver driver) {
        this.driver = driver;
    }

    public void clickStart() {
        driver.findElement(startButton).click();
        // WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(5));
        // wait.until(ExpectedConditions.invisibilityOf(
        //     driver.findElement(loadingIndicator)));

        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(5)) // Set the maximum wait time
                .pollingEvery(Duration.ofSeconds(1)) // Check every second
                .ignoring(NoSuchElementException.class); // Ignore NoSuchElementException when polling
        wait.until(ExpectedConditions.invisibilityOf
                (driver.findElement(loadingIndicator)));
    }

    public String getLoadedText() {
        return driver.findElement(loadedtext).getText();
    }
}
