import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingDropDown {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://letcode.in/dropdowns");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Select the apple using visible text
        WebElement fruits = driver.findElement(By.cssSelector("#fruits"));
        Select select = new Select(fruits);
        select.selectByVisibleText("Apple");

        // Select your super hero's
        WebElement heroes = driver.findElement(By.id("superheroes"));
        Select myHeroes = new Select(heroes);
        boolean isMultiple = myHeroes.isMultiple();
        System.out.println("Is multiple: " + isMultiple);
        myHeroes.selectByIndex(1);
        myHeroes.selectByValue("bt");

        List<WebElement> allHeroes = myHeroes.getAllSelectedOptions();
        allHeroes.forEach(i -> System.out.println(i.getText()));

        // Select India using value & print the selected value
        WebElement country = driver.findElement(By.id("country"));
        Select myCountry = new Select(country);
        myCountry.selectByValue("India");
        WebElement selectedCountry = myCountry.getFirstSelectedOption();
        System.out.println(selectedCountry.getText());

    }
}
