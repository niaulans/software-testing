package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ActivityMenu extends BasePage {

    public ActivityMenu(AndroidDriver driver) {
        super(driver);
    }

    public boolean isAt() {
        return isElementVisible(AppiumBy.accessibilityId("Hello World"));
    }

    public HelloWorldMenu goToHelloWorldMenu() {
        clickByAccessibilityId("Hello World");
        return new HelloWorldMenu(driver);
    }
}
