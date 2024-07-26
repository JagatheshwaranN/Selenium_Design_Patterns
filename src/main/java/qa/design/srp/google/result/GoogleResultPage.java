package qa.design.srp.google.result;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import qa.design.srp.google.common.SearchSuggestion;
import qa.design.srp.google.common.SearchWidget;

public class GoogleResultPage {

    private final SearchWidget searchWidget;

    private final SearchSuggestion searchSuggestion;

    private final NavigationBar navigationBar;

    private final ResultStat resultStat;

    public GoogleResultPage(final WebDriver driver) {
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
        this.searchSuggestion = PageFactory.initElements(driver, SearchSuggestion.class);
        this.navigationBar = PageFactory.initElements(driver, NavigationBar.class);
        this.resultStat = PageFactory.initElements(driver, ResultStat.class);
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }

    public ResultStat getResultStat() {
        return resultStat;
    }

}
