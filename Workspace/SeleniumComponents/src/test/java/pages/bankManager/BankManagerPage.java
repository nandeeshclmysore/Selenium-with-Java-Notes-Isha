package pages.bankManager;

import framework.ReusableLibrary;
import org.openqa.selenium.By;

public class BankManagerPage extends ReusableLibrary {

    private By addCustomerButton = By.xpath("//button[normalize-space(text())='Add Customer']");
    private By openAccountButton = By.xpath("//button[normalize-space(text())='Open Account']");
    private By customersButton = By.xpath("//button[normalize-space(text())='Customers']");

    public void clickOnHomeButton() {
        seleniumUtils.clickOnElement(addCustomerButton, "addCustomerButton");
    }

    public void clickOnCustomerLoginButton() {
        seleniumUtils.clickOnElement(openAccountButton, "openAccountButton");
    }

    public void clickOnBankManagerLoginButton() {
        seleniumUtils.clickOnElement(customersButton, "customersButton");
    }

}
