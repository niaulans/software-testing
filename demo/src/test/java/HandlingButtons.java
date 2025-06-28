import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingButtons {

    @Test
    public void testButtonHandling() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://letcode.in/button");

        // Find the button location
        WebElement findLocationButton = driver.findElement(By.id("position"));
        Point pointLocationButton = findLocationButton.getLocation();
        int x = pointLocationButton.getX();
        int y = pointLocationButton.getY();
        System.out.println("x => " + x + ", y => " + y);

        // Find the color of button
        WebElement btnColor = driver.findElement(By.id("color"));
        String color = btnColor.getCssValue("background-color");
        System.out.println(color);

        // Find the height & weight of the button
        Rectangle rect = driver.findElement(By.id("property")).getRect();
        Dimension dimension = rect.getDimension();
        dimension.getHeight();
        dimension.getWidth();

        // Confirm the button is disabled
        boolean isDisabled = driver.findElement(By.id("isDisabled")).isEnabled();
        System.out.println(isDisabled);
        System.out.println(isDisabled);

        driver.quit();
    }
}
