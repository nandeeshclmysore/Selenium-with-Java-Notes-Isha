package seleniumbasics1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class Synchronization {

    RemoteWebDriver driver;

    public void implicitlyWaitDemo() {
        driver = new ChromeDriver();

        //To get all default capabilities of the opened driver
        System.out.println(driver.getCapabilities());

        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

}
