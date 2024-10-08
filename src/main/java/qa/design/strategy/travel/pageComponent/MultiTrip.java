package qa.design.strategy.travel.pageComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import qa.design.strategy.travel.abstractComponent.Component;
import qa.design.strategy.travel.abstractComponent.ExploreFlight;

public class MultiTrip extends Component implements ExploreFlight {

    private static final By multiTrip = By.id("ctl00_mainContent_rbtnl_Trip_2");

    private static final By multiTripModal = By.id("MultiCityModelAlert");

    private static final By from1 = By.id("ctl00_mainContent_ddl_originStation1_CTXT");

    private static final By to1 = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");

    private static final By from2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");

    private static final By to2 = By.id("ctl00_mainContent_ddl_destinationStation2_CTXT");

    private static String origin1ToSelect = "//div[@id='ctl00_mainContent_ddl_originStation1_CTNR']//a[@value='$']";

    private static String destination1ToSelect = "//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='$']";

    private static String origin2ToSelect = "//div[@id='ctl00_mainContent_ddl_originStation2_CTNR']//a[@value='$']";

    private static String destination2ToSelect = "//div[@id='ctl00_mainContent_ddl_destinationStation2_CTNR']//a[@value='$']";

    private static final By familyCheckbox = By.id("ctl00_mainContent_chk_friendsandfamily");

    private static final By searchFlight = By.id("ctl00_mainContent_btn_FindFlights");

    public MultiTrip(WebDriver driver, By locator) {
        super(driver, locator);
    }

    @Override
    public void inquireFlightAvailability(String origin, String destination) {
        searchElement(multiTrip).click();
        searchElement(multiTripModal).click();
        selectOrigin1City(origin);
        selectDestination1City(destination);
        selectOrigin2City(origin);
        selectDestination2City(destination);
        searchElement(familyCheckbox).click();
        searchElement(searchFlight).click();
    }

    private void selectOrigin1City(String origin) {
        searchElement(from1).click();
        origin1ToSelect = origin1ToSelect.replaceAll("\\$", origin);
        searchElement(By.xpath(origin1ToSelect)).click();
    }

    private void selectDestination1City(String destination) {
        searchElement(to1).click();
        destination1ToSelect = destination1ToSelect.replaceAll("\\$", destination);
        searchElement(By.xpath(destination1ToSelect)).click();
    }

    private void selectOrigin2City(String origin) {
        searchElement(from2).click();
        origin2ToSelect = origin2ToSelect.replaceAll("\\$", origin);
        searchElement(By.xpath(origin2ToSelect)).click();
    }

    private void selectDestination2City(String destination) {
        searchElement(to2).click();
        destination2ToSelect = destination2ToSelect.replaceAll("\\$", destination);
        searchElement(By.xpath(destination2ToSelect)).click();
    }

}
