package qa.bundle.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.bundle.pageObject.TravelHomePage;
import qa.bundle.util.JsonReader;

import java.util.HashMap;
import java.util.List;

public class TravellerTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @Test(dataProvider = "getData")
    public void flightTest(HashMap<String, String> travelDetail) {
        TravelHomePage travelHomePage = new TravelHomePage(driver);
        travelHomePage.navigateTo();
        travelHomePage.getTopNavigation().searchFlight();
        travelHomePage.getFooterNavigation().searchFlight();
        travelHomePage.getTopNavigation().getLinksCount();
        travelHomePage.getFooterNavigation().getLinksCount();
        travelHomePage.setFlightBookingType(travelDetail.get("travelType"));
        travelHomePage.inquireAvail(travelDetail);
    }

    @DataProvider
    public Object[][] getData() {
        String jsonFilePath = "src/test/resources/dataFile/travelDetail.json";
        List<HashMap<String, String>> travelDetailList = JsonReader.getJsonData(jsonFilePath);
        return new Object[][]{
                {travelDetailList.get(0)},
                {travelDetailList.get(1)}
        };
    }

    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }

}
