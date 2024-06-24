package TestCases;

import common.MyScreenRecorder;
import drivers.DriverFactory;
import drivers.DriverHolder;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class TestBase {

    static protected WebDriver driver;

    @BeforeTest()
    @Parameters("browserName")
    public void openHomePage(@Optional("defaultBrowser") String browserName) throws Exception {
        // Start Recording
        MyScreenRecorder.startRecording("Sprint 1");

        driver = DriverFactory.getNewInstance(browserName);
        DriverHolder.setDriver(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.get("https://opensource-demo.orangehrmlive.com/");

    }

    @AfterTest
    public void tearDown() throws Exception {
        if (driver!= null){
            driver.quit();
        }
        MyScreenRecorder.stopRecording();
    }
}
