package qa.fp.stream;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import qa.fp.supplier.DriverFactory;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class MinPriceSelectionTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        if (this.driver == null)
            this.driver = DriverFactory.getDriver("Chrome");
        this.driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        if (this.driver != null)
            this.driver.quit();
    }

    @Test
    public void minPriceCheckBoxSelectionTest() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-stream-table-price.html");
        Optional<List<WebElement>> minPriceRow = this.driver.findElements(By.cssSelector("table#prods tr"))
                .stream()
                .skip(1)
                .map(tableRow -> tableRow.findElements(By.tagName("td")))
                .min(Comparator.comparing(tableDef -> tableDef.get(2).getText()));
        minPriceRow.ifPresent(element -> element.get(3).findElement(By.tagName("input")).click());
        this.driver.findElement(By.id("result")).click();
        String status = this.driver.findElement(By.id("status")).getText();
        Assert.assertEquals(status, "PASS");
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

}
