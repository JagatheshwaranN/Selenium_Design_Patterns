package qa.design.srp.google.common;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.design.srp.google.base.DisplayComponent;

import java.util.concurrent.TimeUnit;

public class SearchWidget extends DisplayComponent {

    @FindBy(name = "q")
    private WebElement searchBox;

    public SearchWidget(WebDriver driver) {
        super(driver);
    }

    public void type(String keyword) {
        this.searchBox.clear();
        for(char ch : keyword.toCharArray()){
            Uninterruptibles.sleepUninterruptibly(10, TimeUnit.MILLISECONDS);
            this.searchBox.sendKeys(ch+"");
        }
    }

    @Override
    public boolean isDisplayed() {
        return this.wdWait.until(driver -> this.searchBox.isDisplayed());
    }

}
