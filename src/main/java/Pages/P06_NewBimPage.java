package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_NewBimPage {

    WebDriver driver;

    public P06_NewBimPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By USER_TAP = By.xpath("//span[@class='oxd-userdropdown-tab']");


    private final By FIRST_NAME_FIELD = By.xpath("//input[@name='firstName']");
    private final By MIDDLE_NAME_FIELD = By.xpath("//input[@name='middleName']");
    private final By LAST_NAME_FIELD = By.xpath("//input[@name='lastName']");
    private final By EMPLOYEE_ID = By.xpath("//*[text()='Employee Id']/parent::*/parent::*//input");
    private final By SAVE_BUTTON = By.xpath("//button[@type='submit']");
    private final By SUCCESS_MSG = By.xpath("//div[@class='oxd-toast-start']");


    public P06_NewBimPage fillFirstNameText(String firstName) {
        driver.findElement(this.FIRST_NAME_FIELD).sendKeys(firstName);
        return this;
    }

    public P06_NewBimPage fillMiddleNameText(String middleName) {
        driver.findElement(this.MIDDLE_NAME_FIELD).sendKeys(middleName);
        return this;
    }

    public P06_NewBimPage fillLastNameText(String lastName) {
        driver.findElement(this.LAST_NAME_FIELD).sendKeys(lastName);
        return this;
    }

    public String getEmployeeIdText() {
        return driver.findElement(this.EMPLOYEE_ID).getAttribute("value");

    }

    public P06_NewBimPage clickOnSaveButton() {
        driver.findElement(SAVE_BUTTON).click();
        return this;
    }

    public String successMsg() {
        return driver.findElement(SUCCESS_MSG).getText();
    }

}
