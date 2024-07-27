package qa.bundle.pageComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import qa.bundle.abstractComponent.Component;
import qa.bundle.abstractComponent.ExploreFlight;

public class RoundTrip extends Component implements ExploreFlight {

    private static final By roundTrip = By.id("ctl00_mainContent_rbtnl_Trip_1");

    private static final By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");

    private static final By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");

    private static String originToSelect = "//div[@id='ctl00_mainContent_ddl_originStation1_CTNR']//a[@value='$']";

    private static String destinationToSelect = "//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='$']";

    private static final By studentCheckbox = By.id("ctl00_mainContent_chk_StudentDiscount");

    private static final By searchFlight = By.id("ctl00_mainContent_btn_FindFlights");

    public RoundTrip(WebDriver driver, By locator) {
        super(driver, locator);
    }

    @Override
    public void inquireFlightAvailability(String origin, String destination) {
        searchElement(roundTrip).click();
        selectOriginCity(origin);
        selectDestinationCity(destination);
        searchElement(studentCheckbox).click();
        searchElement(searchFlight).click();
    }

    private void selectOriginCity(String origin) {
        searchElement(from).click();
        originToSelect = originToSelect.replaceAll("\\$", origin);
        searchElement(By.xpath(originToSelect)).click();
    }

    private void selectDestinationCity(String destination) {
        searchElement(to).click();
        destinationToSelect = destinationToSelect.replaceAll("\\$", destination);
        searchElement(By.xpath(destinationToSelect)).click();
    }

}
