import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDown {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://letcode.in/dropdowns");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Select the apple using visible text
        WebElement fruits = driver.findElement(org.openqa.selenium.By.cssSelector("#fruits"));
        Select select = new Select(fruits);
        select.selectByVisibleText("Apple");

        // Select your super hero's

        // Select India using value & print the selected value
        WebElement fruits = driver.findElement(org.openqa.selenium.By.cssSelector("#fruits"));
    }
}
