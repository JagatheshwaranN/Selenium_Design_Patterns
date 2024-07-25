package qa.design.singleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    private static volatile DriverManager driverManager;
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManager() {

    }

    private void initiateDriver(String browser) {
        switch(browser){
            case "CHROME" -> driverThreadLocal.set(new ChromeDriver());
            case "FIREFOX" -> driverThreadLocal.set(new FirefoxDriver());
            case "EDGE" -> driverThreadLocal.set(new EdgeDriver());
            default -> throw new IllegalArgumentException("Unsupported Browser :: " + browser);
        }
    }

    public static DriverManager getInstance(String browser) {
        if(null == driverManager){
            synchronized (DriverManager.class){
                if(null == driverManager)
                    driverManager = new DriverManager();
            }
        }
        if(null == driverThreadLocal.get())
            driverManager.initiateDriver(browser);
        return driverManager;
    }

    public WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void quitBrowser(){
        if(driverThreadLocal.get() != null){
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }

}
