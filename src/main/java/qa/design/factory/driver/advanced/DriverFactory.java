package qa.design.factory.driver.advanced;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    private static final Map<WebDriverType, Supplier<WebDriver>> driverMap = new HashMap<>();

    private static final Supplier<WebDriver> chromeDriver = ChromeDriver::new;
    private static final Supplier<WebDriver> firefoxDriver = FirefoxDriver::new;
    private static final Supplier<WebDriver> edgeDriver = EdgeDriver::new;

    static {
        driverMap.put(WebDriverType.CHROME, chromeDriver);
        driverMap.put(WebDriverType.FIREFOX, firefoxDriver);
        driverMap.put(WebDriverType.EDGE, edgeDriver);
    }

    public static WebDriver getDriver(WebDriverType driverType){
        return driverMap.get(driverType).get();
    }

}
