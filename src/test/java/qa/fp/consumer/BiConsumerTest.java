package qa.fp.consumer;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import qa.fp.supplier.DriverFactory;

import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

public class BiConsumerTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        this.driver = DriverFactory.getDriver("Chrome");
        this.driver.manage().window().maximize();
    }

    @Test
    public void biConsumerTest() {
        this.driver.get("https://www.google.com/");
        WebElement searchBar = this.driver.findElement(By.name("q"));
        // BiConsumer<WebElement, String> searchBarElement = (ele, val) -> ele.sendKeys(val);
        BiConsumer<WebElement, String> searchBarElement = WebElement::sendKeys;
        searchBarElement.accept(searchBar, "Selenium");
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown(){
        this.driver.quit();
    }

}
