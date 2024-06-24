package TestCases;

import Pages.P06_NewBimPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06_NewBimRegister extends TestBase {
    String firstNAme = "firstName";
    String middleName = "middleName";
    String lastNAme = "lastName";
    static String employeeID;

    @Test(priority = 1, description = "check that i can add new bim")
    public void fillNewBimRegisterPage_P() {
        employeeID = new P06_NewBimPage(driver).getEmployeeIdText();

        new P06_NewBimPage(driver)
                .fillFirstNameText(firstNAme)
                .fillMiddleNameText(middleName)
                .fillLastNameText(lastNAme)
                .clickOnSaveButton();

        Assert.assertTrue(new P06_NewBimPage(driver).successMsg().contains("Successfully Saved"));
    }
}

