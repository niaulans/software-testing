import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowManagement {

    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        System.out.println("Title: " + driver.getTitle());

    }

    @Test
    public void testNewWindowTab() {
       WebDriver newWindows =  driver.switchTo().newWindow(WindowType.WINDOW);
       driver.manage().window().minimize();
       newWindows.get("http://automationpractice.com/index.php?controller=prices-drop");
       System.out.println("Title: " + driver.getTitle());
    }  

    @Test
    public void testWorkingInBothWindowTabs() {
        // Automatically open & switch to the new window or tab
        driver.manage().window().minimize();
        driver.switchTo().newWindow(WindowType.TAB)
                .get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        System.out.println("Title: " + driver.getTitle());

        // Work in the new window or tab
        driver.findElement(By.id("email_create")).sendKeys("Selenium4@TAU.com");
        driver.findElement(By.id("SubmitCreate")).click();

        // Get the window ID handles
        Set<String> allWindowTabs = driver.getWindowHandles();
        Iterator<String> iterate = allWindowTabs.iterator();
        String mainFirstWindow = iterate.next();

        // Switch & work in the main window
        driver.switchTo().window((mainFirstWindow));
        driver.manage().window().minimize();
        driver.findElement(By.id("search_query_top")).sendKeys("Shirt");
        driver.findElement(By.name("submit_search")).click();
        System.out.println("Title: " + driver.getTitle());
    }
}
