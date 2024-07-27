package qa.design.factory.travel.abstractComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import qa.design.factory.travel.pageComponent.MultiTrip;
import qa.design.factory.travel.pageComponent.RoundTrip;

public class StrategyFactory {

    protected WebDriver driver;

    private static final By searchFlightContainer = By.id("flightSearchContainer");

    public StrategyFactory(WebDriver driver) {
        this.driver = driver;
    }

    public ExploreFlight createStrategy(String strategyType) {
        if (strategyType.equalsIgnoreCase("round trip")) {
            return new RoundTrip(driver, searchFlightContainer);
        }
        else if (strategyType.equalsIgnoreCase("multi trip")) {
            return new MultiTrip(driver, searchFlightContainer);
        }
        return null;
    }

}
