package framework;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@UtilityClass //Ensures all methods in the class are static and no object can be created for the class
public class BrowserUtils {

    //Kills all browser openened by autoamtion
    @SneakyThrows
    public void killExistingBrowsers(){

        Runtime.getRuntime().exec("TASKKILL -f -im chromedriver.exe /T");
        Runtime.getRuntime().exec("TASKKILL -f -im firefoxdriver.exe /T");
        Runtime.getRuntime().exec("TASKKILL -f -im edgedriver.exe /T");
    }
    public WebDriver getDriver(String browser) {
        return switch (browser.toUpperCase()) {
            case "CHROME" -> new ChromeDriver();
            case "FIREFOX" -> new FirefoxDriver();
            case "EDGE" -> new EdgeDriver();

            default -> throw new RuntimeException("Given browser " + browser + " is not valid");

        };
    }
}
