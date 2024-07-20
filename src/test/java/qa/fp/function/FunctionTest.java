package qa.fp.function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import qa.fp.supplier.DriverFactory;

import java.util.List;
import java.util.function.Function;

public class FunctionTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        this.driver = DriverFactory.getDriver("Chrome");
        this.driver.manage().window().maximize();
    }

    @Test
    public void getElementTextTest(){
        this.driver.get("https://www.google.com/");
        List<WebElement> links = this.driver.findElements(By.tagName("a"));
        Function<WebElement, String> getTextFunction = WebElement::getText;
        links.stream()
                .map(getTextFunction)
                .forEach(System.out::println);
    }

    @AfterTest
    public void tearDown(){
        this.driver.quit();
    }

}
