package qa.design.factory.driver;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected WebDriver driver;

    public abstract void startService();

    public abstract void stopService();

    public abstract void createDriver();

    public WebDriver getDriver() {
        if(driver == null){
            startService();
            createDriver();
        }
        return driver;
    }

    public void quitDriver() {
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

}
