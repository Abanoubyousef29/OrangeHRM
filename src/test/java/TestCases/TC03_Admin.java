package TestCases;

import Pages.P03_AdminPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import static TestCases.TC04_NewAdminRegister.username;


public class TC03_Admin extends TestBase {

    @Test(priority = 1, description = "check that i can click on add new admin button")
    public void addNewAdminButtonIsWorking_P()  {

        new P03_AdminPage(driver).clickOnAddNewAdmin();

    }

    @Test(priority = 2, description = "check that i can search by username")
    public void searchByUserName_P() {

        new P03_AdminPage(driver).fillUsernameField(username).clickSearchButton();
        Assert.assertTrue(new P03_AdminPage(driver).usernameColumInTable().contains(username));

    }
}
