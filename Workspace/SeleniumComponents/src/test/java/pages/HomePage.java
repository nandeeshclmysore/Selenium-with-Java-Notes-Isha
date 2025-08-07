package pages;

import framework.ReusableLibrary;
import org.openqa.selenium.By;

public class HomePage extends ReusableLibrary {
    private By homeButton= By.xpath("//button[text()='Home']");
    private By customerLoginButton= By.xpath("//button[text()='Customer Login']");
    private By bankManagerLoginButton= By.xpath("//button[text()='Bank Manager Login']");

    public void clickOnHomeButton(){
        seleniumUtils.clickOnElement(homeButton,"Home Button");
    }

    public void clickOnCustomerLoginButton(){
        seleniumUtils.clickOnElement(customerLoginButton,"Customer Login Button");
    }

    public void clickOnBankManagerLoginButton(){
        seleniumUtils.clickOnElement(bankManagerLoginButton,"Bank Manager Login Button");
    }

}
