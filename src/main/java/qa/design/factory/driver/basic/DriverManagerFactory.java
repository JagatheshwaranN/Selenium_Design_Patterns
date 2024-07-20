package qa.design.factory.driver.basic;


public class DriverManagerFactory {

    public static DriverManager getDriverManager(DriverType driverType) {
        return switch (driverType) {
            case CHROME -> new ChromeDriverManager();
            case FIREFOX -> new FirefoxDriverManager();
            case EDGE -> new EdgeDriverManager();
        };
    }

}
