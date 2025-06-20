import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v137.network.model.ConnectionType;
import org.openqa.selenium.devtools.v137.network.Network;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkConditions {
    ChromeDriver driver;
    DevTools devTools;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        devTools = driver.getDevTools();
    }

    @Test 
    public void enableSlowRexJonesII() {
        try {
            devTools.createSession();
            devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

            System.out.println("Applying slow network conditions (3G)...");
            devTools.send(Network.emulateNetworkConditions(
                    false, // offline
                    150,   // latency (ms)
                    2500,  // downloadThroughput (bytes/s)
                    2000,  // uploadThroughput (bytes/s)
                    Optional.of(ConnectionType.CELLULAR3G),
                    Optional.of(1000000),  // maxTotalBufferSize (misalnya 1 MB)
                    Optional.of(1000),     // maxResourceBufferSize (jumlah max buffer per resource)
                    Optional.of(true) 
            ));

            driver.get("https://linkedin.com");
            System.out.println("Enable Slow Network: " + driver.getTitle());
        } catch (Exception e) {
            System.err.println("Error while emulating slow network: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test 
    public void doNotEnableRexJonesII() {
        driver.get("https://linkedin.com");
        System.out.println("Do not Enable Network: " + driver.getTitle());
    }
}
