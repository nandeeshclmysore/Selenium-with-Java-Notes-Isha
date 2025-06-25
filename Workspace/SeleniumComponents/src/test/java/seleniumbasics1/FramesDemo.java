package seleniumbasics1;

import framework.BrowserUtils;
import framework.ElementsUtils;
import framework.SeleniumUtils;
import framework.constants.BrowserTypes;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FramesDemo {

    public WebDriver driver;

    @SneakyThrows
    @Test
    public void framesTest() {

        BrowserUtils.killExistingBrowsers();

        driver = BrowserUtils.getDriver(BrowserTypes.CHROME.getBrowser());

        ElementsUtils elementsUtils = new ElementsUtils(driver);
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver, elementsUtils);

        seleniumUtils.launchApp("https://the-internet.herokuapp.com/nested_frames");

        //Switch to Frames
        //driver.switchTo().frame(index/name or id/Web element)

        //Switch to outer frame
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));

        //Switch to inner frame
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));

        WebElement element1 = driver.findElement(By.xpath("//div[@id='content']"));
        System.out.println(seleniumUtils.performGetTextFromWebelement(element1, "Frame element"));

        //Switch to parent frame
        driver.switchTo().parentFrame();

        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-left']")));

        WebElement element2 = driver.findElement(By.xpath("//body[normalize-space(text())='LEFT']"));
        System.out.println(seleniumUtils.performGetTextFromWebelement(element2
                , "Frame"));

        //Switch to default content
        driver.switchTo().defaultContent();

        seleniumUtils.closeBrowser();

    }
}
