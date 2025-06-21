package seleniumbasics1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class TabsAndWindowHandles {

    public WebDriver driver = null;

    @Test
    public void handlingNewTabsAndSwicthtoSpecifcTab() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        //Get current tab/window handle
        String googleWindowHanlde = driver.getWindowHandle();
        Thread.sleep(3000);

        //To open new Tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.cricbuzz.com");
        Thread.sleep(3000);

        //To open new window
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.cricbuzz.com");
        Thread.sleep(3000);

        //Switch to specific tab using handle value
        driver.switchTo().window(googleWindowHanlde);
        Thread.sleep(3000);

        //Close all new tabs/windows opened by current driver
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

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.facebook.com");
        Thread.sleep(300);

        //To fetch all handles of all tabs/windows opened by current driver and switch to all tabs
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            driver.switchTo().window(handle);
            System.out.println("Title: " + driver.getTitle());
            Thread.sleep(3000);
        }

        driver.quit();

    }


}
