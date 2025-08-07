package pages.customer;

import framework.ReusableLibrary;
import org.openqa.selenium.By;

public class CustomerLoginPage extends ReusableLibrary {
    private By customerNameDropdown = By.cssSelector("#userSelect");
    private By loginButton = By.xpath("//button[text()='Login']");


    public void selectCutomerName(String cname) {
        seleniumUtils.performDropdownSelectionByValue(customerNameDropdown, cname, "customerNameDropdown");
    }

    public void clickOnLoginButton() {
        seleniumUtils.clickOnElement(loginButton, "loginButton");
    }

}
