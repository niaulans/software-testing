package base;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import pages.HomePage;
import utils.GestureManager;

public class BaseTests {

    protected AndroidDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setPlatformVersion("11");
        options.setDeviceName("R9CM906E8XJ");
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity(".ApiDemos");

        options.setNoReset(true);
        options.setFullReset(false);

        driver = new AndroidDriver(new URL("http://localhost:4723/"), options);
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public GestureManager getGestureManager() {
        return new GestureManager(driver);
    }
}
