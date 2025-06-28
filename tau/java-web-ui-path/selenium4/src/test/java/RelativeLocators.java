import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RelativeLocators {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testRelativeLocator() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement loginPanel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5")));
        WebElement credentials = driver.findElement(RelativeLocator.with(By.tagName("div"))
                                .below(loginPanel));
        System.out.println(credentials.getText());
    }

    @Test
    public void testListOfElements() {
        List<WebElement> allSocialMedia = driver.findElements(with(By.tagName("img"))
                    .near(By.id("footer")));

        for (WebElement socialMedia : allSocialMedia) {
            System.out.println(socialMedia.getAttribute("alt"));
        }
    }
}
