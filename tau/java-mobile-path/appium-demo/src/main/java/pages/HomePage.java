package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class HomePage extends BasePage {

    public HomePage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isAt() {
        return isElementVisible(AppiumBy.accessibilityId("App"));
    }

    public AppMenu goToAppMenu() {
        clickByAccessibilityId("App");
        return new AppMenu(driver);
    }
}
