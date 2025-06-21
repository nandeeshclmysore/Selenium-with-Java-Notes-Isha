package framework;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.openqa.selenium.*;

import java.io.File;
import java.nio.file.Files;
import java.util.Set;

@AllArgsConstructor //Based on variable declared it creates constructor on runtime
public class SeleniumUtils {

    private WebDriver driver;

//    public SeleniumUtils(WebDriver driver) {
//        this.driver = driver;
//    }

    public String launchAppAndReturnHandle(String url) {

        if (url.isEmpty() || url.isBlank())
            throw new GenericException(url + " is not valid may be its blank or empty!...");
        else if (url.startsWith("https") || url.startsWith("https"))
            throw new GenericException(url + " not contains protocol info!...");

        driver.get(url);
        driver.manage().window().maximize();
        return driver.getWindowHandle();
    }

    public void launchApp(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void openNewTabAndSwitchAndLaunchApp(String url) {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(url);
    }

    public void openNewWindowAndSwitchAndLaunchApp(String url) {
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get(url);
    }

    public String getWindowHandleOfOpenedTaborWindow() {
        return driver.getWindowHandle();
    }

    public Set<String> getWindowHandlesOfAllOpenedTaborWindow() {
        return driver.getWindowHandles();
    }

    public void clickOnElement(WebElement element, String labelName) {
        if (element == null)
            throw new GenericException("Unable to find an element for " + labelName);

        element.click();
    }

    public void enterDataOnTextBox(WebElement element, String data, String labelName) {
        if (element == null)
            throw new GenericException("Unable to find an element for " + labelName);

        element.sendKeys(data);
    }

    public void closeBrowser() {
        if (driver != null)
            driver.close();

    }

    public void closeAllBrowsers() {
        if (driver != null)
            driver.quit();

    }


}
