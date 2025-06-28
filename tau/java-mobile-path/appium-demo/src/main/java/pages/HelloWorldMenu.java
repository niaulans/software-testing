package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class HelloWorldMenu extends BasePage {

    public HelloWorldMenu(AndroidDriver driver) {
        super(driver);
    }

    public boolean isAt() {
        return isElementVisible(AppiumBy.accessibilityId("Hello World"));
    }

    public String getText() {
        String text = driver.findElement(AppiumBy.accessibilityId("Hello, World!")).getText();
        return text;
    }

}
