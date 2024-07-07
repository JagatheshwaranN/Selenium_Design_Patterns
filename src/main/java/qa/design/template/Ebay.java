package qa.design.template;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Ebay extends ShoppingTemplate {

    private final WebDriver driver;

    private final WebDriverWait wait;

    private final String product;

    @FindBy(id="gh-ac")
    private WebElement searchBox;

    @FindBy(id="gh-btn")
    private WebElement searchButton;

    @FindBy(css="li[id*='item'] .s-item__wrapper .s-item__info .s-item__caption + a")
    private List<WebElement> searchItem;

    @FindBy(css=".x-item-title__mainTitle")
    private WebElement itemTitle;

    public Ebay(WebDriver driver, String product){
        this.driver = driver;
        this.product = product;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @Override
    public void launch() {
        this.driver.get("https://www.ebay.com/");
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
        this.driver.switchTo().window(driver.getWindowHandles().stream().toList().get(1));
    }

    @Override
    public void checkout() {
        this.wait.until(driver -> this.itemTitle.isDisplayed());
        System.out.println(this.itemTitle.getText());
    }
    
}
