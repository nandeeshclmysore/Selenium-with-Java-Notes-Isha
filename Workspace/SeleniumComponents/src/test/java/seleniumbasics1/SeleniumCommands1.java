package seleniumbasics1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class SeleniumCommands1 {

    @Test
    public void launchBrowser() throws InterruptedException {

        WebDriver driver = null;
        String browser = "chrome";

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void handlingNewTabsAndSwicthtoSpecifcTab() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        //Get current tab handle
        String googleWindowHanlde = driver.getWindowHandle();
        Thread.sleep(3000);

        //To open new Tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.cricbuzz.com");
        Thread.sleep(3000);

        //Switch to specific tab using handle value
        driver.switchTo().window(googleWindowHanlde);
        Thread.sleep(3000);

        driver.quit();

    }

    @Test
    public void getAllWindowHandlesAndSwitch() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        Thread.sleep(3000);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.cricbuzz.com");
        Thread.sleep(3000);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.espncricinfo.com");
        Thread.sleep(3000);

        //To fetch all handles of all tabs and switch to all tabs
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            driver.switchTo().window(handle);
            System.out.println("Title: " + driver.getTitle());
            Thread.sleep(3000);
        }

        driver.quit();

    }


}
