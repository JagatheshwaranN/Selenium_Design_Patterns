package qa.design.strategy.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GooglePage {

    protected WebDriver driver;

    protected SearchStrategy strategy;

    @FindBy(css = "div[class='yuRUbf'] h3")
    List<WebElement> searchResult;

    public GooglePage(WebDriver driver, SearchStrategy strategy){
        this.driver = driver;
        this.strategy = strategy;
        this.strategy.setDriver(this.driver);
        PageFactory.initElements(this.driver, this);
        this.driver.get("https://www.google.com/");
    }

    public void search(String keyword){
        this.strategy.search(keyword);
    }

    public int getSearchResultCount() {
        return this.searchResult.size();
    }

}
