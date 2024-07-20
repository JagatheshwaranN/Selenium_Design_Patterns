package qa.fp.consumer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import qa.fp.supplier.DriverFactory;

import java.util.function.Consumer;

public class ConsumerChainingTest {

    private WebDriver driver;

    @BeforeTest
    public void setDriver(){
        this.driver = DriverFactory.getDriver("Chrome");
        this.driver.manage().window().maximize();
    }

    @Test
    public void consumerChainingTest() {
        this.driver.get("https://www.google.com/");
        WebElement searchBar = this.driver.findElement(By.name("q"));
        Consumer<WebElement> height = (ele) -> System.out.println("Element Height :: "+ ele.getSize().getHeight());
        Consumer<WebElement> width = (ele) -> System.out.println("Element Width :: "+ ele.getSize().getWidth());
        Consumer<WebElement> size = height.andThen(width);
        size.accept(searchBar);
    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }

}
