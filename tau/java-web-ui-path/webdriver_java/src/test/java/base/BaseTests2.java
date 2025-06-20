package base;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;

import pages.HomePage;
import utils.WindowManager;

public class BaseTests2 {

    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Pemrograman\\software-testing\\tau\\java-web-ui-path\\webdriver_java\\resources\\chromedriver.exe");

        // ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless");
        // options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver();
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // Set implicit wait, will wait up to 30 seconds for elements to be found, if not found immediately will wait until timeout, and then throw an exception
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
}
