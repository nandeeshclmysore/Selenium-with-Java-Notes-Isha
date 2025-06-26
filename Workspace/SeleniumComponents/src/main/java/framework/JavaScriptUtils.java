package framework;

import lombok.AllArgsConstructor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@AllArgsConstructor
public class JavaScriptUtils {

    public WebDriver driver;

    public void scrollPage(int x, int y) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(" + x + "," + y + ")");

    }

    public void scrollpageToBottom() {
        ((JavascriptExecutor) driver).executeScript(
                "window.scrollBy(0,document.body.scrollHeight)");
    }

    public void scrollpageToTop() {
        ((JavascriptExecutor) driver).executeScript(
                "window.scrollBy(0,-document.body.scrollHeight)");
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "argument[0].scrollIntoView(true);", element);
    }

    public void executeJsFunction(String jsCode) {
        ((JavascriptExecutor) driver).executeScript(
                jsCode);
    }

    public void launchPage(String URL) {
        ((JavascriptExecutor) driver).executeScript("window.location='" + URL + "';");
    }

    public void launchAppInNewTab(String URL) {
        ((JavascriptExecutor) driver).executeScript(
                "window.open('" + URL + "',__black);");
    }

    public void createAlert(String alertMessage) {
        ((JavascriptExecutor) driver).executeScript("alert('" + alertMessage + "');");
    }

    public void highlightElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript
                ("arguments[0].style.border='5px solid orange'", element);
    }

    public void disableHighlightElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript
                ("arguments[0].style.border=''", element);
    }

    public void enterData(WebElement element, String data) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].value='" + data + "';", element);
    }

    public void clickOnElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript
                ("arguments[0].click;", element);
    }

    public void zoomPage(int percentage) {
        ((JavascriptExecutor) driver).executeScript(
                "document.body.style.zoom='" + percentage + "%'");
    }

    public void zoomSpecificElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].style.zoom='50%'", element);
    }

    public WebElement returnShadowElement(WebElement element) {
        return (WebElement) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].shadowRoot", element);
    }


    public WebElement returnWebElement(String jsCode) {
        return (WebElement) ((JavascriptExecutor) driver).executeScript(
                jsCode);
    }


}
