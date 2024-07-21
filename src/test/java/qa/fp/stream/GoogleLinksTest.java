package qa.fp.stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import qa.fp.supplier.DriverFactory;

import java.util.List;

public class GoogleLinksTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        this.driver = DriverFactory.getDriver("Chrome");
        this.driver.manage().window().maximize();
    }

    @Test
    public void googleLinksUsingStreamLambdaTest() {
        this.driver.get("https://www.google.com/");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        links.stream()
                .filter(element -> !element.getText().isEmpty())
                .filter(element -> !element.getText().toLowerCase().contains("s"))
                .map(element -> element.getText().toUpperCase())
                .forEach(System.out::println);
    }

    @Test
    public void googleLinksUsingStreamMethodReferenceTest() {
        this.driver.get("https://www.google.com/");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        links.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .filter(element -> !element.isEmpty())
                .filter(element -> !element.toLowerCase().contains("s"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }

}
