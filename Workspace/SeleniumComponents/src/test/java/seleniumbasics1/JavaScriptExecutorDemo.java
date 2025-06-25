package seleniumbasics1;

import framework.*;
import framework.constants.BrowserTypes;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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


        //Create Alert
        //((JavascriptExecutor)driver).executeScript("alert('Welcome');");

        //Launch application
        //((JavascriptExecutor)driver).executeScript("window.location='https://demo.automationtesting.in/Register.html';");

        //((JavascriptExecutor)driver).executeScript("window.open('https://demo.automationtesting.in/Register.html');");

        //launch app in new tab
//        ((JavascriptExecutor) driver).executeScript(
//                "window.open('https://demo.automationtesting.in/Register.html',__black);");

        //Highlight Element
        //WebElement element = driver.findElement(By.xpath("//label[text()='Full Name* ']"));
        //((JavascriptExecutor) driver).executeScript
        //      ("arguments[0].style.border='5px solid orange'", element);


        //Scroll page for x and y axis
        //((JavascriptExecutor)driver).executeScript("window.scrollBy(0,4000)");

        //Scroll page to bottom
//        ((JavascriptExecutor) driver).executeScript(
//                "window.scrollBy(0,document.body.scrollHeight)");

        //Scroll page to top
//        ((JavascriptExecutor) driver).executeScript(
//                "window.scrollBy(0,-document.body.scrollHeight)");

        //To enter data
        WebElement mobile = driver.findElement(By.xpath("//input[@type='tel']"));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].value='Test data';", mobile);

        //To Click on element
        WebElement register = driver.findElement(By.xpath("//button[@id='submitbtn']"));
        ((JavascriptExecutor) driver).executeScript
                ("arguments[0].click;", register);

        //To Zoom page
        ((JavascriptExecutor) driver).executeScript(
                "document.body.style.zoom='50%'");

        //To zoom specific element
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].style.zoom='50%'", mobile);

        PathUtils.applySleep(3000);
        //seleniumUtils.dismissAlert();
        seleniumUtils.closeBrowser();


    }
}
