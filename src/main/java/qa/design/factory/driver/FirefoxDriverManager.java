package qa.design.factory.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class FirefoxDriverManager extends DriverManager {

    private FirefoxDriverService firefoxDriverService;

    @Override
    public void startService() {
        if (firefoxDriverService == null) {
            try {
                firefoxDriverService = new GeckoDriverService.Builder()
                        .usingAnyFreePort()
                        .build();
                firefoxDriverService.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void stopService() {
        if (firefoxDriverService != null && firefoxDriverService.isRunning()) {
            firefoxDriverService.stop();
        }
    }

    @Override
    public void createDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("start-maximized");
        driver = new FirefoxDriver(firefoxDriverService, firefoxOptions);
    }

}
