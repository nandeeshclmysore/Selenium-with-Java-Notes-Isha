package seleniumbasics1;

import framework.BrowserUtils;
import framework.ElementsUtils;
import framework.PathUtils;
import framework.SeleniumUtils;
import framework.constants.BrowserTypes;
import lombok.SneakyThrows;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ShadowDomDemo {

    public WebDriver driver;

    @SneakyThrows
    @Test
    public void shadowDomtest1() {

        BrowserUtils.killExistingBrowsers();

        driver = BrowserUtils.getDriver(BrowserTypes.CHROME.getBrowser());

        ElementsUtils elementsUtils = new ElementsUtils(driver);
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver, elementsUtils);

        seleniumUtils.launchApp("https://selectorshub.com/shadow-dom-in-iframe/");

        seleniumUtils.performSwitchToFrame("pact", "Frame");

        //Identify element present inside shadow(open) through JS in Console and Use that element to perform Automation

        WebElement element = (WebElement) ((JavascriptExecutor) driver).executeScript(
                "return document.getElementById('snacktime').shadowRoot.getElementById('tea')");
        seleniumUtils.enterDataOnTextBox(element, "Appu", "Text box");

        PathUtils.applySleep(5000);
        seleniumUtils.closeBrowser();

    }
}
