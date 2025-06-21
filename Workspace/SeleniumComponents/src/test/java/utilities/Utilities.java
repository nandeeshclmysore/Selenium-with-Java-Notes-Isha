package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import java.util.Set;

public class Utilities {

    public static WebDriver driver;

    public static String launchAppAndReturnHandle(WebDriver driver,String url) {
        driver=driver;
        driver.get(url);
        return driver.getWindowHandle();
    }

    public static void launchApp(WebDriver driver,String url) {
        driver=driver;
        driver.get(url);
        driver.manage().window().maximize();
    }

    public static void openNewTabAndSwitchAndLaunchApp(String url) {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(url);
    }

    public static void openNewWindowAndSwitchAndLaunchApp(String url) {
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get(url);
    }

    public static String getWindowHandleOfOpenedTaborWindow() {
        return driver.getWindowHandle();
    }

    public static Set<String> getWindowHandlesOfAllOpenedTaborWindow() {
        return driver.getWindowHandles();
    }

    public static void clickOnElement(WebElement element,String labelName){
        if(element==null)
            throw new RuntimeException("Unable to find an element for "+labelName);

        element.click();
    }

    public static void enterDataOnTextBox(WebElement element,String data,String labelName){
        if(element==null)
            throw new RuntimeException("Unable to find an element for "+labelName);

        element.sendKeys(data);
    }

}
