import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AndroidBuiltInAppDemo {

    private AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setPlatformVersion("11");
        options.setDeviceName("R9CM906E8XJ");
        options.setApp(System.getProperty("user.dir") + "/apps/ApiDemos.apk");
        options.setAppPackage("com.sec.android.app.popupcalculator");
        options.setAppActivity(".Calculator");

        driver = new AndroidDriver(new URL("http://localhost:4723/"), options);
    }

    @Test
    public void click_test() {
        driver.findElement(By.id("calc_keypad_btn_01")).click();
        driver.findElement(By.id("calc_keypad_btn_add")).click();
        driver.findElement(By.id("calc_keypad_btn_03")).click();
        driver.findElement(By.id("calc_keypad_btn_equal")).click();
        String result = driver.findElement(By.id("calc_edt_formula")).getText();
        String onlyNumber = result.replaceAll("[^0-9]", "");

        assertEquals(onlyNumber, "4", "The result of 1 + 3 should be 4");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
