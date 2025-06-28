import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingInputs {

    private static ChromeDriver driver;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://letcode.in/edit");

        // Enter your full name
        driver.findElement(By.id("fullName")).sendKeys("Nia Ulan Sari");

        // Append a text and press keyboard tab
        driver.findElement(By.id("join")).sendKeys(" person", Keys.TAB);

        // What is inside the text box
        String text = driver.findElement(By.id("getMe")).getAttribute("value");
        System.out.println(text);

        // Clear the text
        driver.findElement(By.id("clearMe")).clear();

        // Confirm edit field is disabled
        boolean isEdit = driver.findElement(By.id("noEdit")).isEnabled();
        System.out.println(isEdit);

        // Confirm text is readonly
        String isReadOnly = driver.findElement(By.id("dontwrite")).getAttribute("readonly");
        System.out.println(isReadOnly);
    }
}
