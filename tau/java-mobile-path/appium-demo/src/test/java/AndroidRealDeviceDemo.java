import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidRealDeviceDemo {

    private AppiumDriver driver; // Use this driver for general Appium methods (Android and iOS)
    // private AndroidDriver driver; // Use this driver if you want to use
    // Android-specific methods
    private String appButton = "App";

    @BeforeTest
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setPlatformVersion("11");
        options.setDeviceName("R9CM906E8XJ");
        options.setApp(System.getProperty("user.dir") + "/apps/ApiDemos.apk");

        driver = new AndroidDriver(new URL("http://localhost:4723/"), options);
    }

    @Test
    public void clickAppButton() {
        driver.findElement(AppiumBy.accessibilityId(appButton)).click();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
