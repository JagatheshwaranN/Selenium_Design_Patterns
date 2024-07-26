package qa.bundle.travel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import qa.design.srp.travel.pageObject.TravelHomePage;

public class TravellerTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @Test
    public void flightTest() {
        TravelHomePage travelHomePage = new TravelHomePage(driver);
        travelHomePage.navigateTo();
        travelHomePage.getTopNavigation().searchFlight();
        travelHomePage.getFooterNavigation().searchFlight();
        travelHomePage.getTopNavigation().getLinksCount();
        travelHomePage.getFooterNavigation().getLinksCount();
    }

    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }

}
