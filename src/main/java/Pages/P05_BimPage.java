package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_BimPage {

    WebDriver driver;

    public P05_BimPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By ADD_NEW_PIM = By.xpath("//div[@class='orangehrm-header-container']//button[text()=' Add ']");
    private final By ID_LIST_FROM_BIM_TABLE = By.xpath("//div[@class='oxd-table-body'] / div /div / div[2] / div");
    private final By EMPLOYEE_ID_FIELD = By.xpath("//*[text()='Employee Id']/parent::*/parent::*//input");
    private final By SEARCH_BUTTON_IN_BIM = By.xpath("//button[@type='submit']");


    public P05_BimPage clickOnAddNewPim() {
        driver.findElement(this.ADD_NEW_PIM).click();
        return this;
    }

    public P05_BimPage fillEmployeeIdField(String id) {
        driver.findElement(this.EMPLOYEE_ID_FIELD).sendKeys(id);
        return this;
    }


    public P05_BimPage clickSearchButton() {

        driver.findElement(this.SEARCH_BUTTON_IN_BIM).click();
        return this;
    }

    public String employeeIdColumInTable() {
        return driver.findElement(this.ID_LIST_FROM_BIM_TABLE).getText();
    }
}
