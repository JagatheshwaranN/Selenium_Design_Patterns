package qa.fp.predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import qa.fp.supplier.DriverFactory;

import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        this.driver = DriverFactory.getDriver("Chrome");
        this.driver.manage().window().maximize();
    }

    @Test
    public void blankLinksTest(){
        this.driver.get("https://www.google.com/");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        // Predicate<WebElement> elementIsBlank = ele -> ele.getText().trim().length()==0;
        Predicate<WebElement> elementIsBlank = ele -> ele.getText().trim().isEmpty();
        System.out.println("Total Links Before :: "+links.size());
        links.removeIf(elementIsBlank);
        System.out.println("Total Links After :: "+links.size());
        links.forEach(element -> System.out.println(element.getText()));
    }

    @Test
    public void ruleTest(){
        this.driver.get("https://www.google.com/");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total Links Before :: "+links.size());
        RuleEngine.get().forEach(links::removeIf);
        System.out.println("Total Links After :: "+links.size());
        links.forEach(element -> System.out.println(element.getText()));
    }

    @AfterTest
    public void tearDown(){
        this.driver.quit();
    }

}
