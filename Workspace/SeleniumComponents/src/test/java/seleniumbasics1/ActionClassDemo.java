package seleniumbasics1;

import framework.BrowserUtils;
import framework.ElementsUtils;
import framework.Reports;
import framework.SeleniumUtils;
import framework.constants.BrowserTypes;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class ActionClassDemo {
    public WebDriver driver;
    private Actions actions;

    @SneakyThrows
    @Test
    public void mosueHoverTest() {

        BrowserUtils.killExistingBrowsers();

        //Call enum and get browser value->Call getDriver() to initialize driver
        driver = BrowserUtils.getDriver(BrowserTypes.CHROME.getBrowser());

        //Create object for Util class and Element Util class
        ElementsUtils elementsUtils = new ElementsUtils(driver);
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver, elementsUtils);
        Reports reports = new Reports(driver);


        //Using Utils class object call the utilities methods
        seleniumUtils.launchApp("https://the-internet.herokuapp.com/hovers");

        By by = By.xpath("//img[@alt='User Avatar']");
        List<WebElement> list = elementsUtils.findElements(by);

        //List<WebElement> list = driver.findElements(By.xpath("//img[@alt='User Avatar']"));

        //Actions action= new Actions(driver);

        for (WebElement element : list) {
            //action.moveToElement(element).build().perform();

            seleniumUtils.performMouseHover(element);
            reports.takeScreenshotMethod();

            Thread.sleep(3000);
        }

        seleniumUtils.closeBrowser();

    }

    @SneakyThrows
    @Test
    public void dragAndDropTest() {
        BrowserUtils.killExistingBrowsers();

        //Call enum and get browser value->Call getDriver() to initialize driver
        driver = BrowserUtils.getDriver(BrowserTypes.CHROME.getBrowser());

        //Create object for Util class and Element Util class
        ElementsUtils elementsUtils = new ElementsUtils(driver);
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver, elementsUtils);
        Reports reports = new Reports(driver);


        //Using Utils class object call the utilities methods
        seleniumUtils.launchApp("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement source = driver.findElement(By.xpath("//div[@id='column-a']"));
        WebElement dest = driver.findElement(By.xpath("//div[@id='column-b']"));

        //Actions action = new Actions(driver);
        //action.dragAndDrop(source, dest);
        seleniumUtils.performDragAndDrop(source,dest);

        Thread.sleep(3000);

        seleniumUtils.closeBrowser();
    }

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
        seleniumUtils.launchApp("https://the-internet.herokuapp.com/context_menu");

        WebElement element = driver.findElement(By.xpath("//div[@id='hot-spot']"));


        //Actions actions = new Actions(driver);
        //actions.pause(3000).contextClick(element).build().perform();
        seleniumUtils.performRightClick(element);

        System.out.println(seleniumUtils.getTextFromAlert());

        seleniumUtils.acceptAlert();

        seleniumUtils.closeBrowser();


    }
}
