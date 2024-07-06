package qa.design.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoogleEnglish extends GooglePage {


    protected final WebDriver driver;
    protected final WebDriverWait wait;

    @FindBy(name = "q")
    private WebElement searchBar;

    @FindBy(name = "btnk")
    private List<WebElement> searchButton;

    @FindBy(css = "div[class='yuRUbf'] h3")
    List<WebElement> searchResult;

    public GoogleEnglish(final WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @Override
    public void launch() {
        this.driver.get("https://www.google.com/");
    }

    @Override
    public void search(String keyword) {
        this.searchBar.sendKeys(keyword);
        this.searchButton.stream()
                .filter(ele -> ele.isDisplayed() && ele.isEnabled())
                .findFirst()
                .ifPresent(WebElement::click);
    }

    @Override
    public int getResultCount() {
        this.wait.until(driver -> searchResult.size() > 1);
        return this.searchResult.size();
    }

}
