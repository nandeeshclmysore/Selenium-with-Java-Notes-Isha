package seleniumbasics1;

import framework.BrowserUtils;
import framework.ElementsUtils;
import framework.SeleniumUtils;
import framework.constants.BrowserTypes;
import lombok.SneakyThrows;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AlertsDemo {

    public WebDriver driver;

    @SneakyThrows
    @Test
    public void alertTest() {

        BrowserUtils.killExistingBrowsers();

        //Call enum and get browser value->Call getDriver() to initialize driver
        driver = BrowserUtils.getDriver(BrowserTypes.CHROME.getBrowser());

        //Create object for Util class and Element Util class
        ElementsUtils elementsUtils = new ElementsUtils(driver);
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver,elementsUtils);


        //Using Utils class object call the utilities methods
        seleniumUtils.launchApp("https://www.tutorialspoint.com/selenium/practice/alerts.php");

        By by=By.xpath("//button[text()='Alert']");
        WebElement alertButton =elementsUtils.findElement(by);

        seleniumUtils.clickOnElement(alertButton, "Alert Button");

        //Switch to Alert
        //Alert alert = driver.switchTo().alert();

        //Print text
        //System.out.println(alert.getText());

        //Accept alert
       // alert.accept();

        //Close alert
        //alert.dismiss();

        //Send values to alert
        //alert.sendKeys("Value to send");

        System.out.println(seleniumUtils.getTextFromAlert());
        seleniumUtils.acceptAlert();


        seleniumUtils.closeBrowser();

    }


}
