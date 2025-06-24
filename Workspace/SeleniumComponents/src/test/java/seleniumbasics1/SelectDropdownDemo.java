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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropdownDemo {

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

        WebElement element = driver.findElement(By.xpath("//select[@id='Skills']"));

        //Create object for Select class
        Select select = new Select(element);

        //Select by value attribute
        select.selectByValue("Adobe Photoshop");

        //Select by Index
        select.selectByIndex(2);

        //Select by Visible text
        select.selectByVisibleText("Analytics");

        //Select by partial visible text
        select.selectByContainsVisibleText("Certi");

        //Get first selected option Web element
        WebElement firstSelectedElement = select.getFirstSelectedOption();
        System.out.println(firstSelectedElement.getText());

        //Check is the selection is single or multiple
        Boolean status = select.isMultiple();
        System.out.println(status);

        //Get all the Options
        List<WebElement> list = select.getOptions();

        //Using traditional for each loop
//        for (WebElement ele : list) {
//            System.out.println(ele.getText());
//        }

        //Using Lambda expression
        //list.stream().map(x -> x.getText()).forEach(System.out::println);

        //Using Method reference ->GetText() belongs to WebElement interface so directly we can write Interface::Method name
        list.stream().map(WebElement::getText).forEach(System.out::println);

        seleniumUtils.closeBrowser();
    }
}
