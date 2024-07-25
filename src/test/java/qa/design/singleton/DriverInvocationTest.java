package qa.design.singleton;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DriverInvocationTest {

    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setUp(String browser) {
        this.driver = DriverManager.getInstance(browser).getDriver();
        this.driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        DriverManager.quitBrowser();
    }

    @Test
    public void driverInvocationTest() {
        this.driver.get("https://www.selenium.dev/");
        System.out.println(Thread.currentThread().getName() + " :: " + this.driver.getTitle());
        Assert.assertEquals(this.driver.getTitle(), "Selenium");
    }

}
