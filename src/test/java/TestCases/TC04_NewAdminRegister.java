package TestCases;

import Pages.P04_NewAdminRegisterPage;
import Util.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04_NewAdminRegister extends TestBase {
    String roleNAme = "ESS";
    String status = "Enabled";
    static String username ;
    String password = "test1234";
    String confirmPassword = "test1234";

    @Test(priority = 1, description = "check that i can add new admin")
    public void fillNewAdminRegisterPage_P() throws InterruptedException {
        username = Utility.generateRandomString(5);

        new P04_NewAdminRegisterPage(driver)
                .clickOnAddNewAdmin()
                .selectRole(roleNAme)
                .fillTheEmployeeNameWithLoggedUser()
                .clickOnStatusDropDownMenu()
                .selectStatus(status)
                .fillUsernameText(username)
                .fillPasswordText(password)
                .fillConfirmPasswordText(confirmPassword)
                .clickOnSaveButton();

        Assert.assertTrue(new P04_NewAdminRegisterPage(driver).successMsg().contains("Successfully Saved"));

    }
}
