package qa.design.srp.travel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TravelHomePage {

    WebDriver driver;

    By pageSectionElement = By.id("traveller-home");

    public TopNavigation getTopNavigation() {
        return new TopNavigation();
    }

    public FooterNavigation getFooterNavigation() {
        return new FooterNavigation(driver, pageSectionElement);
    }
}
