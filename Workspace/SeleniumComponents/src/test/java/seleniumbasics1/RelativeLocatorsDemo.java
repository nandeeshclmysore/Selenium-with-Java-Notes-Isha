package seleniumbasics1;

import framework.*;
import framework.constants.BrowserTypes;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;


public class RelativeLocatorsDemo {

    public WebDriver driver;


    @SneakyThrows
    @Test
    public void relativeLocatorTest() {
        BrowserUtils.killExistingBrowsers();

        //Call enum and get browser value->Call getDriver() to initialize driver
        driver = BrowserUtils.getDriver(BrowserTypes.CHROME.getBrowser());

        //Create object for Util class and Element Util class
        ElementsUtils elementsUtils = new ElementsUtils(driver);
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver, elementsUtils);
        Reports reports = new Reports(driver);


        //Using Utils class object call the utilities methods
        seleniumUtils.launchApp("https://demo.automationtesting.in/Register.html");

        WebElement referenceElement = driver.findElement(By.xpath(" //input[@type='email']"));

        RelativeLocator.RelativeBy by = RelativeLocator.with(By.xpath("//input[@type='tel']")).below(referenceElement);

        driver.findElement(by).sendKeys("9916454100");

        PathUtils.applySleep(3000);
        seleniumUtils.closeBrowser();


    }


}
