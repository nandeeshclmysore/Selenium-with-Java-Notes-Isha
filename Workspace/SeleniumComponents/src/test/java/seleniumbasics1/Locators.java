package seleniumbasics1;

import framework.BrowserUtils;
import framework.SeleniumUtils;
import framework.constants.BrowserTypes;
import framework.PathUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Locators {

    public WebDriver driver = null;

    @Test
    public void locatorsUseCase1() throws InterruptedException {

        //Call enum and get browser value->Call getDriver() to initialize driver
        driver = BrowserUtils.getDriver(BrowserTypes.CHROME.getBrowser());

        //Create object for Util class
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver);


        //Using Utils class object call the utilities methods
        seleniumUtils.launchApp("https://practicetestautomation.com/practice-test-login/");

        WebElement emailTextbox = driver.findElement(By.id("username"));
        WebElement passwordTextbox = driver.findElement(By.id("password"));
        WebElement signinButton = driver.findElement(By.id("submit"));

        seleniumUtils.enterDataOnTextBox(emailTextbox, "student", "emailTextbox");
        seleniumUtils.enterDataOnTextBox(passwordTextbox, "Password123", "passwordTextbox");

        seleniumUtils.clickOnElement(signinButton, "signinButton");

        Thread.sleep(3000);

        // WebElement logoutButton = driver.findElement(By.linkText("Log out"));
        WebElement logoutButton = driver.findElement(By.className("wp-block-button__link"));

        seleniumUtils.clickOnElement(logoutButton, "logoutButton");
        Thread.sleep(3000);

        seleniumUtils.closeBrowser();

        // wp-block-button__link has-text-color has-background has-very-dark-gray-background-color


    }

    @Test
    public void locatorsUseCase2() {

        BrowserUtils.killExistingBrowsers();

        driver = BrowserUtils.getDriver(BrowserTypes.CHROME.getBrowser());

        //Create object for Util class
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver);

        //Using Utils class object call the utilities methods
        seleniumUtils.launchApp("https://www.cricbuzz.com/");

        WebElement lnk_teams = driver.findElement(By.linkText("Teams"));
        seleniumUtils.clickOnElement(lnk_teams, "Team link");

        //PathUtils.applySleep(3000);

        WebElement lnk_australia = driver.findElement(By.linkText("Australia"));
        seleniumUtils.clickOnElement(lnk_australia, "Australia Team link");

        PathUtils.applySleep(3000);

        seleniumUtils.closeBrowser();


    }
}
