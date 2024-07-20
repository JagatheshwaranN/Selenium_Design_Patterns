package qa.design.strategy.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TextStrategy implements SearchStrategy {

    protected WebDriver driver;

    @FindBy(name= "q")
    private WebElement searchBox;

    @FindBy(xpath = "//input[@name='btnK']")
    private List<WebElement> searchButton;

    @Override
    public void setDriver(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void search(String searchKeyword) {
        searchBox.sendKeys(searchKeyword);
        searchButton.stream()
                .filter(ele -> ele.isDisplayed() && ele.isEnabled())
                .findFirst()
                .ifPresent(WebElement::click);
    }

}
