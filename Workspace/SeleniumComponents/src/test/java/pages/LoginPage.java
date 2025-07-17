package pages;

import framework.ReusableLibrary;
import org.openqa.selenium.By;

public class LoginPage extends ReusableLibrary {

    private By userNameTextbox= By.id("username");
    private By passwordTextbox= By.id("password");
    private By signinButton= By.id("submit");

    public void enterUserName(String username){
        seleniumUtils.enterDataOnTextBox(userNameTextbox,username,"USERNAME TEXT BOX");
    }


    public void enterPasword(String password){
        seleniumUtils.enterDataOnTextBox(passwordTextbox,password,"PASSWORD TEXT BOX");
    }


    public void clickOnLogin(){
        seleniumUtils.clickOnElement(signinButton,"LOGIN BUTTON");
    }

}
