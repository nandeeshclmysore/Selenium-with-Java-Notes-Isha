package seleniumbasics1;

import framework.BrowserUtils;
import framework.Reports;
import framework.SeleniumUtils;
import framework.constants.BrowserTypes;
import framework.constants.PathUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FrameworkComponents {

    public WebDriver driver;

    @Test
    public void screenshotTest() {

        //To close all browsers opened by Automation scripts
        BrowserUtils.killExistingBrowsers();

        //BrowserTypes.CHROME.getBrowser() ->ENUM call to get value of browser
        //BrowserUtils.getDriver() ->Initialize browser driver
        driver = BrowserUtils.getDriver(BrowserTypes.CHROME.getBrowser());

        //Create object for Util class
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver);

        //Creates object for Reports class
        Reports reports=new Reports(driver);

        //Using Utils class object call the utilities methods
        seleniumUtils.launchApp("https://www.cricbuzz.com/");

        WebElement lnk_teams = driver.findElement(By.linkText("Teams"));
        seleniumUtils.clickOnElement(lnk_teams, "Team link");

        //Calls static method of PathUtils class to apply Thread.sleep()
        PathUtils.applySleep(3000);

        WebElement lnk_australia = driver.findElement(By.linkText("Australia"));
        seleniumUtils.clickOnElement(lnk_australia, "Australia Team link");

        PathUtils.applySleep(3000);

        //Calls takeScreenshotMethod() to takes screenshot
        reports.takeScreenshotMethod();

        seleniumUtils.closeBrowser();

    }
}
