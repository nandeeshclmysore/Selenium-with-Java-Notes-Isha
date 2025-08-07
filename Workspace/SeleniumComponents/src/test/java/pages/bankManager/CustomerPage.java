package pages.bankManager;

import framework.ReusableLibrary;
import org.openqa.selenium.By;

public class CustomerPage extends ReusableLibrary {
    private By customerNameSearchBox = By.xpath("//input[@placeholder='Search Customer']");

    public void enterCustomerName(String name) {
        seleniumUtils.enterDataOnTextBox(customerNameSearchBox, name, "customerNameSearchBox");
    }
}
