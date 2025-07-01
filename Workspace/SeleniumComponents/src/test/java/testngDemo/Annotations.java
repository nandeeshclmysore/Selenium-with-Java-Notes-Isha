package testngDemo;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Annotations {

    @Test
    @Parameters({"username", "password"})
    public void loginTest(String username, String password) {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
}