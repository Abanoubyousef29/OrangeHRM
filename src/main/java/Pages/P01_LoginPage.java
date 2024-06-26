package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {

    // 1- define webdriver
    // 2- define constructor and initialize webdriver
    // 3- define locators using By
    // 4- define action methods for each locator

    WebDriver driver;

    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By EMAIL_TEXT = By.xpath("//input[@name='username']");
    private final By PASSWORD_TEXT = By.xpath("//input[@name='password']");
    private final By LOGIN_BUTTON = By.xpath("//button[@type='submit']");

    public P01_LoginPage inputEmail(String email) {
        driver.findElement(this.EMAIL_TEXT).sendKeys(email);
        return this;
    }

    public P01_LoginPage inputPassword(String password) {
        driver.findElement(this.PASSWORD_TEXT).sendKeys(password);
        return this;
    }

    public P01_LoginPage clickLoginButton() {
        driver.findElement(this.LOGIN_BUTTON).click();
        return this;
    }


    public boolean loginButtonIsDisplayed() {
        try {
            driver.findElement(LOGIN_BUTTON);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }

    }

}
