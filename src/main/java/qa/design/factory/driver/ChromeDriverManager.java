package qa.design.factory.driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class ChromeDriverManager extends DriverManager {

    private ChromeDriverService chromeDriverService;

    @Override
    public void startService() {
        if (chromeDriverService == null) {
            try {
                chromeDriverService = new ChromeDriverService.Builder()
                        .usingAnyFreePort()
                        .build();
                chromeDriverService.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void stopService() {
        if (chromeDriverService != null && chromeDriverService.isRunning()) {
            chromeDriverService.stop();
        }
    }

    @Override
    public void createDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeDriverService, chromeOptions);
    }

}
