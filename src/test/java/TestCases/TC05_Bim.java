package TestCases;

import Pages.P05_BimPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static TestCases.TC06_NewBimRegister.employeeID;

public class TC05_Bim extends TestBase {

    @Test(priority = 1, description = "check that i can click on add new pim button")
    public void addNewPimButtonIsWorking_P()  {
        new P05_BimPage(driver).clickOnAddNewPim();
    }

    @Test(priority = 2, description = "check that i can search by employee id")
    public void searchByEmployeeId_P() throws InterruptedException {
        Thread.sleep(1000);
        new P05_BimPage(driver).fillEmployeeIdField(employeeID).clickSearchButton();
        Thread.sleep(1500);
        Assert.assertTrue(new P05_BimPage(driver).employeeIdColumInTable().contains(employeeID));
    }
}
