package qa.design.factory.travel;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.design.factory.travel.pageObject.TravelHomePage;

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
        travelHomePage.inquireAvail("MAA", "BLR");
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
