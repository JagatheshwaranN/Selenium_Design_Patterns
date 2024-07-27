package qa.design.executeAround.travel.pageObject;

import org.openqa.selenium.WebDriver;
import qa.design.executeAround.travel.abstractComponent.ExploreFlight;
import qa.design.executeAround.travel.abstractComponent.StrategyFactory;

import java.util.HashMap;

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

    public void inquireAvail(HashMap<String, String> travelDetail) {
        exploreFlight.inquireFlightAvailability(travelDetail);
    }

}
