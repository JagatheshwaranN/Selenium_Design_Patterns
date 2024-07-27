package qa.design.executeAround.travel;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.design.executeAround.travel.pageObject.TravelHomePage;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TravellerTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @Test(dataProvider = "getData")
    public void flightTest(String travelType) {
        TravelHomePage travelHomePage = new TravelHomePage(driver);
        travelHomePage.navigateTo();
        travelHomePage.setFlightBookingType(travelType);
        HashMap<String, String> travelDetail = new HashMap<>();
        travelDetail.put("origin1", "MAA");
        travelDetail.put("origin2", "BLR");
        travelDetail.put("destination1", "HYD");
        travelDetail.put("destination2", "MAA");
        travelHomePage.inquireAvail(travelDetail);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    @DataProvider
    public Object[] getData() {
        return new Object[]{
                "round trip",
                "multi trip"
        };
    }

    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }

}
