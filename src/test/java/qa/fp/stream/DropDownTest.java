package qa.fp.stream;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.fp.supplier.DriverFactory;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class DropDownTest {

    private WebDriver driver;
    private Actions actions;

    @BeforeTest
    public void setUp() {
        if(this.driver == null)
            this.driver = DriverFactory.getDriver("Chrome");
        this.driver.manage().window().maximize();
        this.actions = new Actions(driver);
    }

    @AfterTest
    public void tearDown() {
        if(this.driver != null)
            this.driver.quit();
    }

    @Test(dataProvider = "getData")
    public void dropDownTest(String path) {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/drop-down.html");
        String[] pathVars = path.split("=>");
        Arrays.stream(pathVars)
                .map(String::trim)
                .map(By::linkText)
                .map(by -> this.driver.findElement(by))
                .map(element -> actions.moveToElement(element))
                .forEach(Actions::perform);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    @DataProvider
    public Object[] getData() {
        return new Object[]{
                "Dropdown => Dropdown Link 1",
                "Dropdown => Dropdown Link 5 => Dropdown Submenu Link 5.1",
                "Dropdown => Dropdown Link 5 => Dropdown Submenu Link 5.4 => Dropdown Submenu Link 5.4.2"
        };
    }

}
