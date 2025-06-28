package exercise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSolution {

    private WebDriver driver;

    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "tau\\java-web-ui-path\\webdriver_java\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.linkText("Shifting Content")).click();
        driver.findElement(By.linkText("Example 1: Menu Element")).click();

        List<WebElement> menuItems = driver.findElements(By.tagName("li"));
        System.out.println("Number of menu items: " + menuItems.size());

        driver.quit();
    }

    public static void main(String[] args) {
        
        FirstSolution test  = new FirstSolution();
        test.setUp();
    }
}
