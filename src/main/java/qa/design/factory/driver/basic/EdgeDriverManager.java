package qa.design.factory.driver.basic;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.IOException;

public class EdgeDriverManager extends DriverManager {

    private EdgeDriverService edgeDriverService;

    @Override
    public void startService() {
        if (edgeDriverService == null) {
            try {
                edgeDriverService = new EdgeDriverService.Builder()
                        .usingAnyFreePort()
                        .build();
                edgeDriverService.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void stopService() {
        if (edgeDriverService != null && edgeDriverService.isRunning()) {
            edgeDriverService.stop();
        }
    }

    @Override
    public void createDriver() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("start-maximized");
        driver = new EdgeDriver(edgeDriverService, edgeOptions);
    }

}
