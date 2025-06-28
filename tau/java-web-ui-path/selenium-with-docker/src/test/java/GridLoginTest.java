import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertTrue;

public class GridLoginTest {

    WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (browser.equalsIgnoreCase("firefox")) {
            capabilities.setBrowserName("firefox");
        } else {
            capabilities.setBrowserName("chrome");
        }

        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        driver.manage().window().maximize();
    }

    @Test
    public void testLoginPage() {
        driver.get("https://the-internet.herokuapp.com/login");

        boolean usernamePresent = driver.findElement(By.id("username")).isDisplayed();
        boolean passwordPresent = driver.findElement(By.id("password")).isDisplayed();

        assertTrue(usernamePresent, "Username field should be visible");
        assertTrue(passwordPresent, "Password field should be visible");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
