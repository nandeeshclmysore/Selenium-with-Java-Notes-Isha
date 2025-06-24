package seleniumbasics1;

import framework.BrowserUtils;
import framework.ElementsUtils;
import framework.Reports;
import framework.SeleniumUtils;
import framework.constants.BrowserTypes;
import lombok.SneakyThrows;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class JavaScriptExecutorDemo {

    public WebDriver driver;


    @SneakyThrows
    @Test
    public void rightClickTest() {
        BrowserUtils.killExistingBrowsers();

        //Call enum and get browser value->Call getDriver() to initialize driver
        driver = BrowserUtils.getDriver(BrowserTypes.CHROME.getBrowser());

        //Create object for Util class and Element Util class
        ElementsUtils elementsUtils = new ElementsUtils(driver);
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver, elementsUtils);
        Reports reports = new Reports(driver);


        //Using Utils class object call the utilities methods
        seleniumUtils.launchApp("https://demo.automationtesting.in/Register.html");

        //Java script executor
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,4000)");

    }
}
