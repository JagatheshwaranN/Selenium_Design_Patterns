package qa.design.template.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AmazonResultPage {

    protected final WebDriver driver;

    private final WebDriverWait wait;

    @FindBy(css="span .a-size-medium")
    private List<WebElement> searchItem;

    public AmazonResultPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void selectProduct() {
        this.wait.until(driver -> this.searchItem.size() > 1);
        this.searchItem.stream()
                .filter(ele -> ele.isDisplayed() && ele.isEnabled())
                .findFirst()
                .ifPresent(WebElement::click);
    }

}
