package base;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.google.common.io.Files;

import pages.HomePage;
import utils.CookieManager;
import utils.WindowManager;

public class BaseTests {

    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Pemrograman\\software-testing\\tau\\java-web-ui-path\\webdriver_java\\resources\\chromedriver.exe");

        WebDriver originalDriver = new ChromeDriver(getChromeOptions());
        WebDriverListener listener = new MyListener();
        driver = new EventFiringDecorator<WebDriver>(listener).decorate(originalDriver);
       
        driver.get("https://the-internet.herokuapp.com/");

        homePage = new HomePage(driver);

    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
        
    }

    @AfterClass
    public void tearDown() {
        driver.quit();  
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if(ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            // System.out.println("Screenshot taken: " + screenshot.getAbsolutePath());

            try {
                Files.move(screenshot, new File("D:\\Pemrograman\\software-testing\\tau\\java-web-ui-path\\webdriver_java\\resources\\screenshots\\" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } 
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("disable-infobars"); //deprecates
        // options.addArguments("--headless"); // Run in headless mode (no GUI)
        return options;
    }

    public CookieManager getCookieManager() {
        return new CookieManager(driver);
    }

}
