package qa.design.srp.google.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.design.srp.google.base.DisplayComponent;

import java.util.List;

public class SearchSuggestion extends DisplayComponent {

    @FindBy(css = "li.sbct")
    private List<WebElement> autoSuggestion;

    public SearchSuggestion(WebDriver driver) {
        super(driver);
    }

    public void clickOnSuggestion(int index){
        this.autoSuggestion.get(index - 1).click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wdWait.until(driver -> this.autoSuggestion.size() > 5);
    }

}
