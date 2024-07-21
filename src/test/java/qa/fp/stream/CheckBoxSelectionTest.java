package qa.fp.stream;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.fp.supplier.DriverFactory;

import java.util.concurrent.TimeUnit;

public class CheckBoxSelectionTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        this.driver = DriverFactory.getDriver("Chrome");
        this.driver.manage().window().maximize();
    }

    @Test(dataProvider = "testData")
    public void checkboxSelectionTest(String gender) {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table.html");
        this.driver.findElements(By.tagName("tr"))
                .stream()
                .skip(1)
                .map(tableRow -> tableRow.findElements(By.tagName("td")))
                .filter(tableDefList -> tableDefList.size() == 4)
                .filter(tableDefList -> tableDefList.get(1).getText().equalsIgnoreCase(gender))
                .map(tableDefList -> tableDefList.get(3))
                .map(tableDef -> tableDef.findElement(By.tagName("input")))
                .forEach(WebElement::click);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    @DataProvider
    public Object[] testData() {
        return new Object[]{
                "male",
                "female"
        };
    }

    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }

}
