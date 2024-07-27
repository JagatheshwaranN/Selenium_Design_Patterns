package qa.bundle.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import qa.bundle.abstractComponent.TravelFactory;
import qa.bundle.pageComponent.FooterNavigation;
import qa.bundle.pageComponent.TopNavigation;
import qa.bundle.abstractComponent.ExploreFlight;

import java.util.HashMap;

public class TravelHomePage {

    protected WebDriver driver;

    private static final By topPageSectionElement = By.id("buttons");

    private static final By footerPageSectionElement = By.id("traveller-home");

    private static final By searchFlightContainer = By.id("flightSearchContainer");

    ExploreFlight exploreFlight;

    public TravelHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        this.driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public TopNavigation getTopNavigation() {
        return new TopNavigation(driver, topPageSectionElement);
    }

    public FooterNavigation getFooterNavigation() {
        return new FooterNavigation(driver, footerPageSectionElement);
    }

    public void setFlightBookingType(String travelType){
        TravelFactory travelFactory = new TravelFactory();
        this.exploreFlight = travelFactory.createTravelStrategy(driver, searchFlightContainer, travelType);
    }

    public void inquireAvail(HashMap<String, String> travelDetail) {
        exploreFlight.inquireFlightAvailability(travelDetail);
    }

}
