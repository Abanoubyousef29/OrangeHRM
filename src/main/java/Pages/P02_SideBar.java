package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_SideBar {

    // 1- define webdriver
    // 2- define constructor and initialize webdriver
    // 3- define locators using By
    // 4- define action methods for each locator

    WebDriver driver;

    public P02_SideBar(WebDriver driver) {
        this.driver = driver;
    }

    private final By USER_TAP = By.xpath("//span[@class='oxd-userdropdown-tab']");
    private final By ADMIN_FROM_LEFT_PANAL = By.xpath("//ul[@class='oxd-main-menu']//span[text()='Admin']");
    private final By PIM_FROM_LEFT_PANAL = By.xpath("//ul[@class='oxd-main-menu']//span[text()='PIM']");
    private final By HOME_PAGE_HEADER = By.xpath("//div[@class='oxd-topbar-header']");
    private final By SIDE_TAPES = By.xpath("//ul[@class='oxd-main-menu']//span");


    public boolean userNameAppear() {
        return driver.findElement(this.USER_TAP).isDisplayed();
    }

    public P02_SideBar clickOnAdminTap() {
        driver.findElement(this.ADMIN_FROM_LEFT_PANAL).click();
        return this;
    }

    public int totalSideTaps() {
        return driver.findElements(this.SIDE_TAPES).size();
    }

    public P02_SideBar clickOnSideTapByNumber(int x) {
        driver.findElements(this.SIDE_TAPES).get(x).click();
        return this;
    }

    public String returnTapNAme(int x) {
        return driver.findElements(this.SIDE_TAPES).get(x).getText();

    }

    public P02_SideBar clickOnPimTap() {
        driver.findElement(this.PIM_FROM_LEFT_PANAL).click();
        return this;
    }

    public String returnHeader() {
        return driver.findElement(this.HOME_PAGE_HEADER).getText();

    }


}
