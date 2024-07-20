package qa.design.factory.driver.advanced;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class DriverInvocationTest {

    private WebDriver driver;

    @BeforeTest()
    public void setUp() {
        this.driver = DriverFactory.getDriver(WebDriverType.CHROME);
        this.driver.manage().window().maximize();
    }

    @Test
    public void launchBrowserTest() {
        this.driver.get("https://www.selenium.dev/");
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        Assert.assertEquals(this.driver.getTitle(), "Selenium");
    }

    @AfterTest
    public void tearDown(){
        this.driver.quit();
    }

}
