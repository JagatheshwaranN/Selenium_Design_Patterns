package qa.fp.supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    // private static final Supplier<WebDriver> chromeDriver = () -> new ChromeDriver();
    private static final Supplier<WebDriver> chromeDriver = ChromeDriver::new;
    private static final Supplier<WebDriver> firefoxDriver = FirefoxDriver::new;
    private static final Supplier<WebDriver> edgeDriver = EdgeDriver::new;

    private static final Map<String, Supplier<WebDriver>> driverMap = Map.of(
            "Chrome", chromeDriver,
            "Firefox", firefoxDriver,
            "Edge", edgeDriver
    );

    public static WebDriver getDriver(String browser) {
        return driverMap.get(browser).get();
    }

}
