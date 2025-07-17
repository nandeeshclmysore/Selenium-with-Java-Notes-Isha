package tests;

import data_providers.Login_DP;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.Map;

public class LoginFunctionalityTest extends TESTNGBase {

    private LoginPage loginPage;

    @Test(description = "Successfull Login Test", enabled = false)
    public void validateLoginWithValidCredentials() {

        loginPage = new LoginPage();

        loginPage.enterUserName("student");
        loginPage.enterPasword("Password123");
        loginPage.clickOnLogin();
    }

    @Test(description = "Successfull Login Test with DP", dataProvider = "loginDataProvider", dataProviderClass = Login_DP.class)
    public void validateLoginWithValidCredentialsWithDP(Map<String, String> data) {

        loginPage = new LoginPage();

        loginPage.enterUserName(data.get("username"));
        loginPage.enterPasword(data.get("password"));
        loginPage.clickOnLogin();
    }


}
