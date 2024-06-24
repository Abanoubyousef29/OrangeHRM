package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_NewAdminRegisterPage {

    WebDriver driver;

    public P04_NewAdminRegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By USER_TAP = By.xpath("//span[@class='oxd-userdropdown-tab']");
    private final By SELECT_USER_DROP_DOWN_LIST = By.xpath("//*[text()='User Role']/parent::*/parent::*/*[2]");
    private final By EMPLOYEE_NAME = By.xpath("//*[text()='Employee Name']/parent::*/parent::*//input");
    private final By SELECT_STATUS_DROP_DOWN_LIST = By.xpath("//*[text()='Status']/parent::*/parent::*/*[2]");
    private final By USERNAME_FIELD = By.xpath("//*[text()='Username']/parent::*/parent::*/*[2]/input");
    private final By PASSWORD_FIELD = By.xpath("//*[text()='Password']/parent::*/parent::*/*[2]/input");
    private final By CONFIRM_PASSWORD_FIELD = By.xpath("//*[text()='Confirm Password']/parent::*/parent::*/*[2]/input");
    private final By SAVE_BUTTON = By.xpath("//button[@type='submit']");


    private final By SUCCESS_MSG = By.xpath("//div[@class='oxd-toast-start']");



    public P04_NewAdminRegisterPage clickOnAddNewAdmin() {
        driver.findElement(SELECT_USER_DROP_DOWN_LIST).click();
        return this;
    }

    public P04_NewAdminRegisterPage selectRole(String roleNAme) {
        driver.findElement(By.xpath("//*[text()='User Role']/parent::*/parent::*/*[2] // *[text()='" + roleNAme + "']")).click();
        return this;
    }

    public P04_NewAdminRegisterPage fillTheEmployeeNameWithLoggedUser() throws InterruptedException {
        driver.findElement(EMPLOYEE_NAME).sendKeys(driver.findElement(USER_TAP).getText());

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Employee Name']/parent::*/parent::* /div[2]/div/div[2]")).click();

        return this;
    }

    public P04_NewAdminRegisterPage clickOnStatusDropDownMenu() {
        driver.findElement(SELECT_STATUS_DROP_DOWN_LIST).click();
        return this;
    }

    public P04_NewAdminRegisterPage selectStatus(String status)  {
        driver.findElement(By.xpath("//*[text()='Status']/parent::*/parent::*/*[2] // *[text()='" + status + "']"))
                .click();
        return this;
    }

    public P04_NewAdminRegisterPage fillUsernameText(String username) {
        driver.findElement(USERNAME_FIELD).sendKeys(username);
        return this;
    }

    public P04_NewAdminRegisterPage fillPasswordText(String password) {
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        return this;
    }

    public P04_NewAdminRegisterPage fillConfirmPasswordText(String confirmPassword) {
        driver.findElement(CONFIRM_PASSWORD_FIELD).sendKeys(confirmPassword);
        return this;
    }

    public P04_NewAdminRegisterPage clickOnSaveButton() {
        driver.findElement(SAVE_BUTTON).click();
        return this;
    }

    public String successMsg() {
        return driver.findElement(SUCCESS_MSG).getText();
    }

}
