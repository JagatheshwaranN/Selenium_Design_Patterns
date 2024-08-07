package qa.design.srp.google;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.design.srp.google.home.GoogleHomePage;
import qa.design.srp.google.result.GoogleResultPage;
import qa.design.test.BaseTest;

public class GoogleTest extends BaseTest {

    private GoogleHomePage googleHomePage;

    private GoogleResultPage googleResultPage;

    @BeforeTest
    public void setUpPages() {
        this.googleHomePage = new GoogleHomePage(driver);
        this.googleResultPage = new GoogleResultPage(driver);
    }

    @Test(dataProvider = "fetchData")
    public void googleSearchFlowTest(String keyword, int index){
        googleHomePage.navigateTo();
        Assert.assertTrue(googleHomePage.getSearchWidget().isDisplayed());
        googleHomePage.getSearchWidget().type(keyword);
        Assert.assertTrue(googleHomePage.getSearchSuggestion().isDisplayed());
        googleHomePage.getSearchSuggestion().clickOnSuggestion(index);
        Assert.assertTrue(googleResultPage.getNavigationBar().isDisplayed());
        googleResultPage.getSearchWidget().type(keyword);
        Assert.assertTrue(googleResultPage.getSearchSuggestion().isDisplayed());
        googleResultPage.getSearchSuggestion().clickOnSuggestion(index);
        googleResultPage.getNavigationBar().navigateToNews();
        System.out.println(googleResultPage.getResultStat().getResultStatistics());
    }

    @DataProvider
    public Object[][] fetchData() {
        return new Object[][]{
                {
                    "Selenium", 3
                },
                {
                    "Docker", 2
                }
        };
    }

}
