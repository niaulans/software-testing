package exercise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class First {

    private WebDriver driver;

    public void findShiftingContent() {

        System.setProperty("webdriver.chrome.driver", "tau\\java-web-ui-path\\webdriver_java\\resources\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        WebElement shiftingContentLink = driver.findElement(By.linkText("Shifting Content"));
        shiftingContentLink.click();

        WebElement menuElementLink = driver.findElement(By.partialLinkText("Example 1"));
        menuElementLink.click();

        List<WebElement> navBar = driver.findElements(By.xpath("//ul/li"));
        System.out.println(navBar.size());

    } 

    public static void main(String[] args) {
        First firstExercise = new First();
        firstExercise.findShiftingContent();
    }
}
