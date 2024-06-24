package Pages;

import Util.Utility;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PageBase {


    public static void hoverToListOfElementAndSelectOne(WebDriver driver, String number, List<WebElement> categoriesTapList) throws InterruptedException {

        final int parentIndex;
        Actions actionMouse = new Actions(driver);

        if (number == "random") {
            // generate a random number based on the last number in the category list
            parentIndex = Utility.generateRandomNumberBasedOnMaxNumberList(categoriesTapList.size());
        } else {
            parentIndex = Integer.parseInt(number);
        }

        // generate a random parent category index
        WebElement parentCategory = categoriesTapList.get(parentIndex);
        actionMouse.moveToElement(parentCategory).perform();

        // check if the hovered element contains any subcategory
        if (parentCategory.findElements(By.tagName("li")).size() > 0) {

            // get the list of subcategories
            List<WebElement> categorySubList = parentCategory.findElements(By.tagName("li"));

            // generate a random subcategory index
            int subIndex = Utility.generateRandomNumberBasedOnMaxNumberList(categorySubList.size());
            WebElement subCategory = categorySubList.get(subIndex);
            subCategory.click();
        } else {
            // if no subcategory, click on the parent category
            parentCategory.click();
        }
    }

    static void hoverToElementByText(WebDriver driver, String elementName) throws InterruptedException {

        Actions actionMouse = new Actions(driver);

        // generate a random parent category index
        WebElement elementByText = driver.findElement(By.xpath("//*[contains(text(), '" + elementName + "')]"));

        actionMouse.moveToElement(elementByText).perform();
    }

    public static void hoverToElementByTextAndClick(WebDriver driver, String elementName) throws InterruptedException {

        Actions actionMouse = new Actions(driver);

        // generate a random parent category index
        WebElement elementByText = driver.findElement(By.xpath("//*[contains(text(), '" + elementName + "')]"));

        actionMouse.moveToElement(elementByText).click().perform();
    }

    // TODO: Capture Screenshot
    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;


        try {
            FileHandler.copy(takesScreenshot.getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir")
                    + "/src/test/resources/Screenshots/" + screenshotName + timeRightNowInRightFormat() + ".png"));
        } catch (WebDriverException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String timeRightNowInRightFormat(){
        // Get the current time in milliseconds since Unix epoch
        long currentTimeMillis = System.currentTimeMillis();

        // Convert milliseconds to Instant
        Instant instant = Instant.ofEpochMilli(currentTimeMillis);

        // Define the format you want
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm.ss");

        // Convert Instant to a formatted string in UTC (or use a specific time zone)
        String formattedDateTime = formatter.format(instant.atZone(ZoneId.of("UTC")));

        return formattedDateTime;
    }

}
