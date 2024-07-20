package qa.fp.supplier;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SupplierTest {

    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("Chrome") String browser) {
        this.driver = DriverFactory.getDriver(browser);
        this.driver.manage().window().maximize();
    }

    @Test
    public void seleniumSiteTest() {
        this.driver.get("https://www.selenium.dev/");
        Assert.assertEquals(this.driver.getTitle(), "Selenium");
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }

}
