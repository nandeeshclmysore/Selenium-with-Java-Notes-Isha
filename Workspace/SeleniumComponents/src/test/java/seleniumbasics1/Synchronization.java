package seleniumbasics1;

import framework.ElementsUtils;
import framework.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Synchronization {

    RemoteWebDriver driver;

    @Test
    public void implicitlyAndExplicitWaitDemo() throws InterruptedException {
        driver = new ChromeDriver();

        //To get all default capabilities of the opened driver
        System.out.println(driver.getCapabilities());

        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Create object for Util class
        ElementsUtils elementsUtils = new ElementsUtils(driver);
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver,elementsUtils);

        //Using Utils class object call the utilities methods
        seleniumUtils.launchApp("https://practicetestautomation.com/practice-test-login/");

        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //By as argument
        WebElement emailTextbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        //WebElement as argument
        WebElement passwordTextbox = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("password"))));
        WebElement signinButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("submit"))));

        seleniumUtils.enterDataOnTextBox(emailTextbox, "student", "emailTextbox");
        seleniumUtils.enterDataOnTextBox(passwordTextbox, "Password123", "passwordTextbox");


        seleniumUtils.clickOnElement(signinButton, "signinButton");

        Thread.sleep(3000);

        seleniumUtils.closeBrowser();
    }

}
