package pages.bankManager;

import framework.ReusableLibrary;
import org.openqa.selenium.By;

public class OpenAccountPage extends ReusableLibrary {
    private By customerNameDropdown = By.cssSelector("#userSelect");
    private By currencyDropdown = By.cssSelector("#currency");
    private By processButton = By.xpath("//button[text()='Process']");


    public void selectCutomerName(String cname) {
        seleniumUtils.performDropdownSelectionByValue(customerNameDropdown, cname, "customerNameDropdown");
    }

    public void selectCurrency(String currency) {
        seleniumUtils.performDropdownSelectionByValue(currencyDropdown, currency, "currencyDropdown");
    }

    public void clickOnProcessButton() {
        seleniumUtils.clickOnElement(processButton, "processButton");
    }
}
