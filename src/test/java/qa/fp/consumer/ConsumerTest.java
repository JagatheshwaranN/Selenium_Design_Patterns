package qa.fp.consumer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import qa.fp.supplier.DriverFactory;

public class ConsumerTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        this.driver = DriverFactory.getDriver("Chrome");
        this.driver.manage().window().maximize();
    }

    @Test
    public void linksTest() {
        this.driver.get("https://www.google.com/");
        this.driver.findElements(By.tagName("a")).forEach(element -> System.out.println(element.getText()));
    }

    @AfterTest
    public void tearDown(){
        this.driver.quit();
    }

}
