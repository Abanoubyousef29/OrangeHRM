package TestCases;

import Pages.P02_SideBar;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02_SideBar extends TestBase {

    @Test(priority = 1, description = "check that user tap appear on home screen")
    public void userTapAppearOnHomeScreen_P() {
        Assert.assertTrue(new P02_SideBar(driver).userNameAppear());
    }

    @Test(priority = 2, description = "check that when click on admin tab")
    public void adminPageIsClickable_P() {
        new P02_SideBar(driver).clickOnAdminTap();
    }

    @Test(priority = 3, description = "check that when click on pim tab")
    public void pimPageIsClickable_P() {
        new P02_SideBar(driver).clickOnPimTap();
    }

    @Test(priority = 4, description = "check that when click on a tab i will be redirected to the roght tap page")
    public void checkTapsRedirection_P() {
        for (int x = 0; x < new P02_SideBar(driver).totalSideTaps(); x++) {
            if ("My Info".equals(new P02_SideBar(driver).returnTapNAme(x)) ||
                    "Maintenance".equals(new P02_SideBar(driver).returnTapNAme(x))) {
                System.out.println("1");
            } else {
                new P02_SideBar(driver).clickOnSideTapByNumber(x);

                Assert.assertTrue((new P02_SideBar(driver).returnHeader()).
                        contains(new P02_SideBar(driver).returnTapNAme(x)));
            }
        }
    }
}

