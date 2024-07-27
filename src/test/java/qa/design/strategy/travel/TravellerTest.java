package qa.design.strategy.travel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import qa.design.strategy.travel.pageComponent.MultiTrip;
import qa.design.strategy.travel.pageObject.TravelHomePage;

public class TravellerTest {

    private WebDriver driver;

    private static final By searchFlightContainer = By.id("flightSearchContainer");

    @BeforeTest
    public void setUp() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @Test
    public void flightTest() {
        TravelHomePage travelHomePage = new TravelHomePage(driver);
        travelHomePage.navigateTo();
        // travelHomePage.setFlightBookingType(new RoundTrip(driver, searchFlightContainer));
        travelHomePage.setFlightBookingType(new MultiTrip(driver, searchFlightContainer));
        travelHomePage.inquireAvail("MAA", "BLR");
    }

    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }

}
