package qa.design.srp.google.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import qa.design.srp.google.common.SearchSuggestion;
import qa.design.srp.google.common.SearchWidget;

public class GoogleHomePage {

    private final WebDriver driver;

    private final SearchWidget searchWidget;

    private final SearchSuggestion searchSuggestion;

    public GoogleHomePage(final WebDriver driver){
        this.driver = driver;
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
        this.searchSuggestion = PageFactory.initElements(driver, SearchSuggestion.class);
    }

    public void navigateTo(){
        this.driver.get("https://www.google.com/");
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }

}
