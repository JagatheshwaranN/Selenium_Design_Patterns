package qa.design.template.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSearchPage {

    private final WebDriver driver;

    @FindBy(id="twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id="nav-search-submit-button")
    private WebElement searchButton;

    public AmazonSearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void launch() {
        this.driver.get("https://www.amazon.com/");
    }

    public void searchProduct(String product) {
        this.searchBox.sendKeys(product);
        this.searchButton.click();
    }

}
