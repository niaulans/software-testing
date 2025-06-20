import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v135.emulation.Emulation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Optional;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GeoLocation {
    ChromeDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test 
    public void mockGeoLocation() {
        Map<String, Object> coordinates = new HashMap<>()
        {{
            put("latitude", 3.574962);
            put("longitude",98.713700);
            put("accuracy", 1);
        }};

       driver.executeCdpCommand("Emulation.setGeoLocationOverride", coordinates); 
       driver.get("https://my-location.org/");
    }

    @Test
    public void mockGeoLocation_DevTools(){
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Emulation.setGeolocationOverride(
                Optional.<Number>of(3.574962),
                Optional.<Number>of(98.713700),
                Optional.<Number>of(1)));
        driver.get("https://my-location.org/");
    }
}
