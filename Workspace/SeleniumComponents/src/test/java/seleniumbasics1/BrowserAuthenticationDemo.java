package seleniumbasics1;

import framework.BrowserUtils;
import framework.ElementsUtils;
import framework.PathUtils;
import framework.SeleniumUtils;
import framework.constants.BrowserTypes;
import lombok.SneakyThrows;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class BrowserAuthenticationDemo {

    public WebDriver driver;

    @SneakyThrows
    @Test
    public void selenium3Approach() {

        BrowserUtils.killExistingBrowsers();
        driver = BrowserUtils.getDriver(BrowserTypes.CHROME.getBrowser());

        ElementsUtils elementsUtils = new ElementsUtils(driver);
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver, elementsUtils);

        //Passing UN and PW direct in URL: Not safe and not supports special characters
        //https://<userName>:<password>@url
        seleniumUtils.launchApp("https://admin:admin@the-internet.herokuapp.com/basic_auth");


        PathUtils.applySleep(3000);
        seleniumUtils.closeBrowser();
    }

    @SneakyThrows
    @Test
    public void selenium4Approach() {

        BrowserUtils.killExistingBrowsers();
        driver = BrowserUtils.getDriver(BrowserTypes.CHROME.getBrowser());

        ElementsUtils elementsUtils = new ElementsUtils(driver);
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver, elementsUtils);

        //Using HasAuthentication interface and register()
        ((HasAuthentication) driver).register(UsernameAndPassword.of("admin", "admin"));
        seleniumUtils.launchApp("https://the-internet.herokuapp.com/basic_auth");

        PathUtils.applySleep(3000);
        seleniumUtils.closeBrowser();
    }
}
