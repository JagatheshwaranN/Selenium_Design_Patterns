package qa.design.strategy.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TextStrategy implements SearchStrategy {

    protected WebDriver driver;

    @FindBy(name= "q")
    private WebElement searchBox;

    @FindBy(xpath = "//div[@class='lJ9FBc']//input[@name='btnK']")
    private WebElement searchButton;

    @Override
    public void setDriver(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void search(String searchKeyword) {
        searchBox.sendKeys(searchKeyword);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.click();
    }

}
