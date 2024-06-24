package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_AdminPage {

    WebDriver driver;

    public P03_AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By ADD_NEW_ADMIN = By.xpath("//div[@class='orangehrm-header-container']//button[text()=' Add ']");
    private final By USERNAME_LIST_FROM_ADMIN_TABLE = By.xpath("//div[@class='oxd-table-body'] / div /div / div[2] / div");
    private final By USERNAME_FIELD = By.xpath("//*[text()='Username']/parent::*/parent::*/*[2]/input");
    private final By SEARCH_BUTTON = By.xpath("//button[@type='submit']");


    public P03_AdminPage clickOnAddNewAdmin(){
        driver.findElement(ADD_NEW_ADMIN).click();
        return this;
    }

    public P03_AdminPage fillUsernameField(String username){
        driver.findElement(USERNAME_FIELD).sendKeys(username);
        return this;
    }

    public P03_AdminPage clickSearchButton(){
        driver.findElement(SEARCH_BUTTON).click();
        return this;
    }

    public String usernameColumInTable(){
        return driver.findElement(USERNAME_LIST_FROM_ADMIN_TABLE).getText();
    }

}
