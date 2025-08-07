package framework;

import lombok.AllArgsConstructor;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor //Based on variable declared it creates constructor on runtime
public class SeleniumUtils {

    WebDriver driver;
    ElementsUtils elementsUtils;

    // ElementsUtils elementsUtils=new ElementsUtils(driver);

    //public SeleniumUtils(WebDriver driver) {
    //   this.driver = driver;
    //}

    public String performGetTextFromWebelement(WebElement element, String label) {
        return element.getText();
    }
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

    public void launchAppInFullScreen(String url) {
        driver.get(url);
        driver.manage().window().fullscreen();
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
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            throw new GenericException("Something went wrong on clicking element" + labelName);
        } catch (StaleElementReferenceException e) {
            throw new GenericException("Something went wrong, Element got Staled" + labelName);
        }

    }

    public void clickOnElement(By by, String labelName) {
        WebElement element=elementsUtils.findElement(by);
        if (element == null)
            throw new GenericException("Unable to find an element for " + labelName);

        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            throw new GenericException("Something went wrong on clicking element" + labelName);
        } catch (StaleElementReferenceException e) {
            throw new GenericException("Something went wrong, Element got Staled" + labelName);
        }
    }

    public void clickOnElement(By by, String labelName, long time) {
        WebElement element = elementsUtils.findElement(by, time);
        if (element == null)
            throw new GenericException("Unable to find an element for " + labelName);

        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            throw new GenericException("Something went wrong on clicking element" + labelName);
        } catch (StaleElementReferenceException e) {
            throw new GenericException("Something went wrong, Element got Staled" + labelName);
        }
    }

    public void enterDataOnTextBox(WebElement element, String data, String labelName) {
        if (element == null)
            throw new GenericException("Unable to find an element for " + labelName);

        element.sendKeys(data);
    }

    public void enterDataOnTextBox(By by, String data, String labelName) {
        WebElement element = elementsUtils.findElement(by);
        if (element == null)
            throw new GenericException("Unable to find an element for " + labelName);

        element.sendKeys(data);
    }

    public void closeBrowser() {
        try {
            Thread.sleep(1000);
            driver.close();
        } catch (Exception e) {
            System.out.println("Browser already closed: " + e.getMessage());
        }

    }

    public void closeAllBrowsers() {
        try {
            Thread.sleep(1000);
            driver.quit();
        } catch (Exception e) {
            System.out.println("Browser already closed: " + e.getMessage());
        }

    }

    //Optional.ofNullable ->Checks if given object is returning null or not
    //Whole agenda of Optional is to avoid Null Pointer Exception
    public Optional<Alert> checkIfAlertIsPresent(int sec) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
            return Optional.ofNullable(wait.until(ExpectedConditions.alertIsPresent()));
        } catch (TimeoutException e) {
            throw new GenericException("Unable to find an Alert after waiting for " + sec);
        }

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

    public void performMouseHover(By by) {
        Actions action = new Actions(driver);
        action.moveToElement(elementsUtils.findElement(by)).build().perform();
    }

    public void performDragAndDrop(By source, By destination) {
        Actions action = new Actions(driver);
        action.pause(3000).dragAndDrop(elementsUtils.findElement(source), elementsUtils.findElement(destination)).build().perform();
    }

    public void performMouseHover(By by, long time) {
        Actions action = new Actions(driver);
        action.moveToElement(elementsUtils.findElement(by, time)).build().perform();
    }

    public void performDragAndDrop(By source, By destination, long time) {
        Actions action = new Actions(driver);
        action.pause(3000).dragAndDrop(elementsUtils.findElement(source, time), elementsUtils.findElement(destination, time)).build().perform();
    }

    public void performRightClick(By by, long time) {
        Actions action = new Actions(driver);
        action.pause(3000).contextClick(elementsUtils.findElement(by, time)).build().perform();
    }

    public void performRightClick(By by) {
        Actions action = new Actions(driver);
        action.pause(3000).contextClick(elementsUtils.findElement(by)).build().perform();
    }

    public void performRightClick(WebElement element) {
        Actions action = new Actions(driver);
        action.pause(3000).contextClick(element).build().perform();
    }

    public void performDoubleClick(By by, long time) {
        Actions action = new Actions(driver);
        action.pause(3000).doubleClick(elementsUtils.findElement(by, time)).build().perform();
    }

    public void performDoubleClick(By by) {
        Actions action = new Actions(driver);
        action.pause(3000).doubleClick(elementsUtils.findElement(by)).build().perform();
    }

    public void performDoubleClick(WebElement element) {
        Actions action = new Actions(driver);
        action.pause(3000).doubleClick(element).build().perform();
    }

    //Scrolling using JS
    public void performVerticalScroll(int x, int y) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    //Select dropdown options
    public void performDropdownSelectionByValue(WebElement element, String value, String label) {
        Select select = new Select(element);

        try {
            select.selectByValue(value);
        } catch (Exception e) {
            throw new GenericException("Something went wrong in selecting the option" + label);
        }

    }

    public void performDropdownSelectionByValue(By by, String value, String label) {
        Select select = new Select(elementsUtils.findElement(by));

        try {
            select.selectByValue(value);
        } catch (Exception e) {
            throw new GenericException("Something went wrong in selecting the option" + label);
        }

    }


    public void performDropdownSelectionByVisibleText(WebElement element, String value, String label) {
        Select select = new Select(element);

        try {
            select.selectByVisibleText(value);
        } catch (Exception e) {
            throw new GenericException("Something went wrong in selecting the option" + label);
        }

    }

    public void performDropdownSelectionByIndex(WebElement element, int index, String label) {
        Select select = new Select(element);

        try {
            select.selectByIndex(index);
        } catch (Exception e) {
            throw new GenericException("Something went wrong in selecting the option" + label);
        }

    }

    public void performDropdownSelectionByPartialVisibleText(WebElement element, String value, String label) {
        Select select = new Select(element);

        try {
            select.deSelectByContainsVisibleText(value);
        } catch (Exception e) {
            throw new GenericException("Something went wrong in selecting the option" + label);
        }

    }

    public void performDropdownRandomSelection(WebElement element,String label) {
        Select select = new Select(element);

        try {
            List<WebElement> list = select.getOptions();
            select.selectByIndex(ThreadLocalRandom.current().nextInt(0, list.size() - 1));
        } catch (Exception e) {
            throw new GenericException("Something went wrong in selecting the option" + label);
        }

    }


    //FRAMES
    public void performSwitchToFrame(WebElement element, long sec, String label) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
            Optional.ofNullable(wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element)))
                    .orElseThrow(() -> new GenericException("Unable to switch to frame " + label));

        } catch (NoSuchFrameException e) {
            throw new GenericException("Frame " + label + " not Exist");
        }
    }

    public void performSwitchToFrame(String idOrName, String label) {

        try {
            driver.switchTo().frame(idOrName);

        } catch (NoSuchFrameException e) {
            throw new GenericException("Frame " + label + " not Exist");
        }
    }

    public void performSwitchToFrame(int index, String label) {

        try {
            driver.switchTo().frame(index);

        } catch (NoSuchFrameException e) {
            throw new GenericException("Frame " + label + " not Exist");
        }
    }

    public void performSwitchToFrame(WebElement element, String label) {

        try {
            driver.switchTo().frame(element);

        } catch (NoSuchFrameException e) {
            throw new GenericException("Frame " + label + " not Exist");
        }
    }

    public void performSwitchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public void performSwitchOutOfAllFrame() {
        driver.switchTo().defaultContent();
    }
}
