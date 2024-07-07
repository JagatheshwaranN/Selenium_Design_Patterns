package qa.design.template;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Amazon extends ShoppingTemplate {

    private final WebDriver driver;

    private final WebDriverWait wait;

    private final String product;

    @FindBy(id="twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id="nav-search-submit-button")
    private WebElement searchButton;

    @FindBy(css="span .a-size-medium")
    private List<WebElement> searchItem;

    @FindBy(id="productTitle")
    private WebElement itemTitle;

    public Amazon(WebDriver driver, String product){
        this.driver = driver;
        this.product = product;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @Override
    public void launch() {
        this.driver.get("https://www.amazon.com/");
    }

    @Override
    public void searchProduct() {
        this.searchBox.sendKeys(product);
        this.searchButton.click();
    }

    @Override
    public void selectProduct() {
        this.wait.until(driver -> this.searchItem.size() > 1);
        this.searchItem.stream()
                .filter(ele -> ele.isDisplayed() && ele.isEnabled())
                .findFirst()
                .ifPresent(WebElement::click);
    }

    @Override
    public void checkout() {
        this.wait.until(driver -> this.itemTitle.isDisplayed());
        System.out.println(this.itemTitle.getText());
    }

}
