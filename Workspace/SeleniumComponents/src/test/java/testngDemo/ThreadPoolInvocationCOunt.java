package testngDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ThreadPoolInvocationCOunt {

    @Test(invocationCount = 2,threadPoolSize = 2)
    public void getTitleTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println("Tilte: " + driver.getTitle());
        driver.close();
    }
}
