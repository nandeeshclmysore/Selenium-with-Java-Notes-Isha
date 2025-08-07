package pages.bankManager;

import framework.ReusableLibrary;
import org.openqa.selenium.By;

public class AddCustomerPage extends ReusableLibrary {

    private By firstNameTextBox = By.xpath("//input[@placeholder='First Name']");
    private By lastNameTextBox = By.xpath("//input[@placeholder='Last Name']");
    private By postalCodeTextBox = By.xpath("//input[@placeholder='Post Code']");
    private By addCustomerButton = By.xpath("//button[text()='Add Customer']");



    public void enterFirstName(String fname){
        seleniumUtils.enterDataOnTextBox(firstNameTextBox,fname,"firstNameTextBox");
    }

    public void enterLastName(String lname){
        seleniumUtils.enterDataOnTextBox(lastNameTextBox,lname,"lastNameTextBox");
    }

    public void enterPostCode(String pcode){
        seleniumUtils.enterDataOnTextBox(postalCodeTextBox,pcode,"postalCodeTextBox");
    }

    public void clickOnAddCustomerButton(){
        seleniumUtils.clickOnElement(addCustomerButton,"addCustomerButton");
    }



}
