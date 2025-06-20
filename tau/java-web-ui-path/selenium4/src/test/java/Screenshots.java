import org.openqa.selenium.OutputType;
import java.io.IOException;
import org.openqa.selenium.io.FileHandler;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshots {
    private WebDriver driver;
    
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://applitools.com/");
    }

    @Test 
    public void takeWebElementScreenshot() throws IOException{
        WebElement nextGenerationPlatform = driver.findElement(By.cssSelector("#post-8 h1"));
        File source = nextGenerationPlatform.getScreenshotAs(OutputType.FILE);
        File destination = new File("Next Generation Platfom.png");
        FileHandler.copy(source, destination);

    }

    @Test 
    public void takeWebElementPageSectionScreenshot() throws IOException {
        WebElement applitoolsPageSection = driver.findElement(By.xpath("//div[@class='wp-block-group pt-default pb-default']//div[@class='wp-block-columns is-layout-flex wp-container-core-columns-is-layout-9d6595d7 wp-block-columns-is-layout-flex']"));
        File source = applitoolsPageSection.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("Applitools Page Section.png"));
    }

    @Test 
    public void takeFullPageScreenshot() throws IOException {
        File source = ((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);
        FileHandler.copy(source, new File("Applitools Full Page Screenshot.png"));

    }
}
