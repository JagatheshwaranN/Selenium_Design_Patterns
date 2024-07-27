package qa.bundle.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import qa.bundle.pageComponent.FooterNavigation;
import qa.bundle.pageComponent.TopNavigation;
import qa.bundle.abstractComponent.ExploreFlight;

public class TravelHomePage {

    WebDriver driver;

    By topPageSectionElement = By.id("buttons");

    By footerPageSectionElement = By.id("traveller-home");

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

    public void setFlightBookingType(ExploreFlight exploreFlight){
        this.exploreFlight = exploreFlight;
    }

    public void inquireAvail(String origin, String destination) {
        exploreFlight.inquireFlightAvailability(origin, destination);
    }

}
