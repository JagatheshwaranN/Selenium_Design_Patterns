package qa.design.strategy.google;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.design.strategy.google.driver.DriverFactory;
import qa.design.strategy.google.driver.WebDriverType;

import java.time.Duration;

public class GoogleSearchTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        this.driver = DriverFactory.getDriver(WebDriverType.CHROME);
        this.driver.manage().window().maximize();
    }

    @Test(dataProvider = "fetchData")
    public void googleSearchTest(SearchStrategy strategy, String keyword, int resultCount) {
        GooglePage googlePage = new GooglePage(this.driver, strategy);
        googlePage.search(keyword);
        Assert.assertEquals(googlePage.getSearchResultCount(), resultCount);
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
    }

    @AfterTest
    public void tearDown(){
        this.driver.quit();
    }

    @DataProvider
    public Object[][] fetchData(){
        return new Object[][]{
                {new TextStrategy(), "Selenium", 11},
                {new SpeechStrategy(), "will it rain tomorrow", 14}
        };
    }

}
