package qa.design.executeAround.travel.pageComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import qa.design.executeAround.travel.abstractComponent.Component;
import qa.design.executeAround.travel.abstractComponent.ExploreFlight;

import java.util.HashMap;
import java.util.function.Consumer;

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

    private static final By studentCheckbox = By.id("ctl00_mainContent_chk_StudentDiscount");

    private static final By searchFlight = By.id("ctl00_mainContent_btn_FindFlights");

    public MultiTrip(WebDriver driver, By locator) {
        super(driver, locator);
    }

    @Override
    public void inquireFlightAvailability(HashMap<String, String> travelDetail) {
        makeMultiTripSectionReady(m -> selectOrigin1City(travelDetail.get("origin1")));
        selectDestination1City(travelDetail.get("destination1"));
        selectOrigin2City(travelDetail.get("origin2"));
        selectDestination2City(travelDetail.get("destination2"));
        searchElement(studentCheckbox).click();
        searchElement(searchFlight).click();
    }

    public void makeMultiTripSectionReady(Consumer<MultiTrip> consumer) {
        searchElement(multiTrip).click();
        searchElement(multiTripModal).click();
        waitForElementToDisappear(multiTripModal);
        consumer.accept(this);
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
