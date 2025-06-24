package seleniumbasics1;

import framework.*;
import framework.constants.BrowserTypes;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class DynamicDropdownDemo {
    public WebDriver driver;
    private Actions actions;

    @SneakyThrows
    @Test
    public void selectDropdownTest() {

        BrowserUtils.killExistingBrowsers();

        //Call enum and get browser value->Call getDriver() to initialize driver
        driver = BrowserUtils.getDriver(BrowserTypes.CHROME.getBrowser());

        //Create object for Util class and Element Util class
        ElementsUtils elementsUtils = new ElementsUtils(driver);
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver, elementsUtils);
        Reports reports = new Reports(driver);


        //Using Utils class object call the utilities methods
        seleniumUtils.launchApp("https://demo.automationtesting.in/Register.html");

        WebElement element = driver.findElement(By.xpath("//label[text()='Languages']/following-sibling::div"));


        seleniumUtils.clickOnElement(element, "Dropdown");

        List<WebElement> options = driver.findElements(By.xpath("//label[text()='Languages']/following-sibling::div//div[2]/ul/li/a"));

        System.out.println(options.size());

        //Fetch all values and print
        //options.stream().map(WebElement::getText).forEach(System.out::println);

        //Select any one specific value
        //options.stream().filter(s -> s.getText().equalsIgnoreCase("Dutch")).findAny()
            //    .ifPresent(s -> seleniumUtils.clickOnElement(s, "Language Option"));

        //Select multiple value
        //options.stream().filter(s -> s.getText().equalsIgnoreCase("Dutch")||s.getText().equalsIgnoreCase("Hindi"))
           //     .forEach(s->seleniumUtils.clickOnElement(s,"Dropdown Option"));


        //Select all values
        //List<WebElement> optionsAfterSelecting = driver.findElements(By.xpath("//label[text()='Languages']/following-sibling::div//div[2]/ul/li/a"));
        //optionsAfterSelecting.stream().forEach(s->seleniumUtils.clickOnElement(s,"Dropdown Options"));

        List<WebElement> optionsAfterSelecting = driver.findElements(By.xpath("//label[text()='Languages']/following-sibling::div//div[2]/ul/li/a"));
        optionsAfterSelecting.stream().forEach(s->
        {
            PathUtils.applySleep(1000);
            System.out.println(s.getText());
            seleniumUtils.clickOnElement(s,"Dropdown Options");
            seleniumUtils.performVerticalScroll(0,10);
        });



        //System.out.println(optionsAfterSelecting.size());


        seleniumUtils.closeBrowser();
    }

}
