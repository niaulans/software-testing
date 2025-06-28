package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AppMenu extends BasePage {

    public AppMenu(AndroidDriver driver) {
        super(driver);
    }

    public boolean isAt() {
        return isElementVisible(AppiumBy.accessibilityId("Activity"));
    }

    public ActivityMenu goToActivityMenu() {
        clickByAccessibilityId("Activity");
        return new ActivityMenu(driver);
    }
}
