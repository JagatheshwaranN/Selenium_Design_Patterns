package qa.design.strategy.google.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    private static final Map<WebDriverType, Supplier<WebDriver>> driverMap = new HashMap<>();

    private static final Supplier<WebDriver> chromeDriver = () -> {
        ChromeOptions chromeOptions = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        Map<String, Object> contentSettings = new HashMap<>();
        Map<String, Object> profile = new HashMap<>();
        // Allow microphone
        contentSettings.put("media_stream", 1); // 1 means allow
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);
        // Apply the preferences to ChromeOptions
        chromeOptions.setExperimentalOption("prefs", prefs);
        return new ChromeDriver(chromeOptions);
    };
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
