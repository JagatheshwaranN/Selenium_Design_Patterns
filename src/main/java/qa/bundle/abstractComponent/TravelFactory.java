package qa.bundle.abstractComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import qa.bundle.pageComponent.MultiTrip;
import qa.bundle.pageComponent.RoundTrip;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class TravelFactory {

    private static final Map<String, BiFunction<WebDriver, By, ExploreFlight>> driverMap = new HashMap<>();

    private static final BiFunction<WebDriver, By, ExploreFlight> roundTrip = RoundTrip::new;
    private static final BiFunction<WebDriver, By, ExploreFlight> multiTrip = MultiTrip::new;

    static {
        driverMap.put("roundTrip", roundTrip);
        driverMap.put("multiTrip", multiTrip);
    }

    public ExploreFlight createTravelStrategy(WebDriver driver, By travelContainer, String travelType) {
        return driverMap.get(travelType).apply(driver, travelContainer);
    }

}
