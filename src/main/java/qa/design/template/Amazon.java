package qa.design.template;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import qa.design.template.pages.AmazonProductPage;
import qa.design.template.pages.AmazonResultPage;
import qa.design.template.pages.AmazonSearchPage;

public class Amazon extends ShoppingTemplate {

    protected final WebDriver driver;

    private final String product;

    private final AmazonSearchPage amazonSearchPage;
    private final AmazonResultPage amazonResultPage;
    private final AmazonProductPage amazonProductPage;

    public Amazon(WebDriver driver, String product){
        this.driver = driver;
        this.product = product;
        this.amazonSearchPage = PageFactory.initElements(driver, AmazonSearchPage.class);
        this.amazonResultPage = PageFactory.initElements(driver, AmazonResultPage.class);
        this.amazonProductPage = PageFactory.initElements(driver, AmazonProductPage.class);
    }

    @Override
    public void launch() {
        this.amazonSearchPage.launch();
    }

    @Override
    public void searchProduct() {
        this.amazonSearchPage.searchProduct(this.product);
    }

    @Override
    public void selectProduct() {
        this.amazonResultPage.selectProduct();
    }

    @Override
    public void checkout() {
        this.amazonProductPage.checkout();
    }

}
