package qa.bundle.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.bundle.pageObject.TravelHomePage;

public class TravellerTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @Test(dataProvider = "getData")
    public void flightTest(String travelType, String origin, String destination) {
        TravelHomePage travelHomePage = new TravelHomePage(driver);
        travelHomePage.navigateTo();
        travelHomePage.getTopNavigation().searchFlight();
        travelHomePage.getFooterNavigation().searchFlight();
        travelHomePage.getTopNavigation().getLinksCount();
        travelHomePage.getFooterNavigation().getLinksCount();
        travelHomePage.setFlightBookingType(travelType);
        travelHomePage.inquireAvail(origin, destination);
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {"roundTrip", "MAA", "BLR"},
                {"multiTrip", "MAA", "BLR"},
        };
    }

    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }

}
