package TestCases;

import Pages.P01_LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_Login extends TestBase {

    //define test data
    String email = "Admin";
    String password = "admin123";

    // check login positive scenario

    @Test(priority = 1, description = "check login function with valid email and valid password")
    public void loginWithValidEmailAndValidPassword_P() {
        new P01_LoginPage(driver).inputEmail(email).inputPassword(password).clickLoginButton();

        // Take screen shot
        //captureScreenshot(driver,"screenshot after login ");

        Assert.assertFalse(new P01_LoginPage(driver).loginButtonIsDisplayed());

    }
}
