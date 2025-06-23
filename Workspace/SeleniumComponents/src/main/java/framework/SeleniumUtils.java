package framework;

import lombok.AllArgsConstructor;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor //Based on variable declared it creates constructor on runtime
public class SeleniumUtils {

    WebDriver driver;
    ElementsUtils elementsUtils;

    // ElementsUtils elementsUtils=new ElementsUtils(driver);

    //public SeleniumUtils(WebDriver driver) {
    //   this.driver = driver;
    //}

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

    public void clickOnElement(By by, String labelName) {
        WebElement element=elementsUtils.findElement(by);
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

    //Optional.ofNullable ->Checks if given object is returning null or not
    //Whole agenda of Optional is to avoid Null Pointer Exception
    public Optional<Alert> checkIfAlertIsPresent(int sec) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        return Optional.ofNullable(wait.until(ExpectedConditions.alertIsPresent()));
    }

    public void acceptAlert() {
        checkIfAlertIsPresent(5).ifPresentOrElse(alert -> alert.accept(), () -> {
            throw new GenericException("Alert is not Present");
        });
    }

    public void dismissAlert() {
        checkIfAlertIsPresent(5).ifPresentOrElse(alert -> alert.dismiss(), () -> {
            throw new GenericException("Alert is not Present");
        });
    }

    public void enterDataIntoAlert(String data) {
        checkIfAlertIsPresent(5).ifPresentOrElse(alert -> {
            alert.sendKeys(data);
            alert.accept();
        }, () -> {
            throw new GenericException("Alert is not Present");
        });
    }

    public String getTextFromAlert() {
        return checkIfAlertIsPresent(5).map(Alert::getText).orElseThrow(
                () -> new GenericException("Alert is not Present"));

    }

    public void performMouseHover(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public void performDragAndDrop(WebElement source,WebElement destination){
        Actions action = new Actions(driver);
        action.pause(3000).dragAndDrop(source, destination).build().perform();
    }


}
