package qa.design.factory.google;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.design.test.BaseTest;

public class GoogleSearchTest extends BaseTest {

    protected GooglePage googlePage;

    @Test(dataProvider = "fetchData")
    public void searchTest(String language, String keyword) {
        this.googlePage = GoogleFactory.getInstance(language, this.driver);
        this.googlePage.launch();
        this.googlePage.search(keyword);
        int resultCount = this.googlePage.getResultCount();
        System.out.println("Result Count : " + resultCount);
    }

    @DataProvider
    public Object[][] fetchData(){
        return new Object[][] {
                {"EN", "Selenium"},
                {"FR", "Design Patterns"},
                {"SA", "Docker"},
                {"ES", "Test NG"}
        };
    }

}
