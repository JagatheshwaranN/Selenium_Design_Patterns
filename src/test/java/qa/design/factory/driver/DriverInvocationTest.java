package qa.design.factory.driver;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class DriverInvocationTest {

    DriverManager driverManager;

    WebDriver driver;

    @BeforeTest()
    public void beforeTest() {
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
    }

    @BeforeMethod()
    public void beforeMethod() {
        driver = driverManager.getDriver();
    }

    @AfterMethod
    public void afterMethod() {
        driverManager.quitDriver();
    }

    @Test
    public void launchBrowserTest() {
        driver.get("https://www.selenium.dev/");
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        Assert.assertEquals(driver.getTitle(), "Selenium");
    }

}
