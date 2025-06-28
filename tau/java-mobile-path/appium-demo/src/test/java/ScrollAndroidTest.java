import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.interactions.Sequence;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ScrollAndroidTest {

    private AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("R9CM906E8XJ");
        options.setPlatformVersion("11");
        // options.setApp(System.getProperty("user.dir") + "/apps/ApiDemos.apk"); //
        // Install app
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity(".ApiDemos");

        options.setNoReset(true); // No app reset
        options.setFullReset(false); // No reinstall app

        driver = new AndroidDriver(new URL("http://localhost:4723/"), options);
    }

    @Test
    public void scrollTest() {
        WebElement viewsButton = driver.findElement(AppiumBy.accessibilityId("Views"));

        // Tap
        int centerX = viewsButton.getLocation().getX() + (viewsButton.getSize().getWidth() / 2);
        int centerY = viewsButton.getLocation().getY() + (viewsButton.getSize().getHeight() / 2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(tap));

        // ScrollDown
        // TouchAction action =
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
