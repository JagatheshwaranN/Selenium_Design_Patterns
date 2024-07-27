package qa.design.strategy.travel.pageObject;

import org.openqa.selenium.WebDriver;
import qa.design.strategy.travel.abstractComponent.ExploreFlight;

public class TravelHomePage {

    WebDriver driver;

    ExploreFlight exploreFlight;

    public TravelHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        this.driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public void setFlightBookingType(ExploreFlight exploreFlight){
        this.exploreFlight = exploreFlight;
    }

    public void inquireAvail(String origin, String destination) {
        exploreFlight.inquireFlightAvailability(origin, destination);
    }

}
