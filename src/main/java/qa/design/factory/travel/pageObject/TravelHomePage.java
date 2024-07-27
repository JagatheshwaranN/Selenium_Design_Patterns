package qa.design.factory.travel.pageObject;

import org.openqa.selenium.WebDriver;
import qa.design.factory.travel.abstractComponent.ExploreFlight;
import qa.design.factory.travel.abstractComponent.StrategyFactory;

public class TravelHomePage {

    WebDriver driver;

    ExploreFlight exploreFlight;

    public TravelHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        this.driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public void setFlightBookingType(String strategyType){
        StrategyFactory strategyFactory = new StrategyFactory(driver);
        exploreFlight = strategyFactory.createStrategy(strategyType);
    }

    public void inquireAvail(String origin, String destination) {
        exploreFlight.inquireFlightAvailability(origin, destination);
    }

}
