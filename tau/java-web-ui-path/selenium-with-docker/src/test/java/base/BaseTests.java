package base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

import pages.HomePage;

public class BaseTests {

    protected WebDriver driver;
    protected HomePage homePage;
    protected String browser;

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) throws MalformedURLException {
        this.browser = browser;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (browser.equalsIgnoreCase("firefox")) {
            capabilities.setBrowserName("firefox");
        } else {
            capabilities.setBrowserName("chrome");
        }
        driver = new RemoteWebDriver(new URL("http://localhost:4444/"), capabilities);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if(ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                String fileName = result.getName() + "_" + browser + ".png";
                Files.move(screenshot, new File("D:\\Pemrograman\\software-testing\\tau\\java-web-ui-path\\selenium-with-docker\\resources\\screenshots\\" + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        driver.quit();
    }

}
