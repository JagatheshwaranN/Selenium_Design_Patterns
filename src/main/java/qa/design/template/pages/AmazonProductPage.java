package qa.design.template.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonProductPage {

    protected final WebDriver driver;

    private final WebDriverWait wait;

    @FindBy(id="productTitle")
    private WebElement itemTitle;

    public AmazonProductPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void checkout() {
        this.wait.until(driver -> this.itemTitle.isDisplayed());
        System.out.println(this.itemTitle.getText());
    }

}
