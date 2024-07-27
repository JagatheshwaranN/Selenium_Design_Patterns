package qa.design.srp.travel.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import qa.design.srp.travel.pageComponent.FooterNavigation;
import qa.design.srp.travel.pageComponent.TopNavigation;

public class TravelHomePage {

    WebDriver driver;

    private static final By topPageSectionElement = By.id("buttons");

    private static final By footerPageSectionElement = By.id("traveller-home");

    public TravelHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        this.driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public TopNavigation getTopNavigation() {
        return new TopNavigation(driver, topPageSectionElement);
    }

    public FooterNavigation getFooterNavigation() {
        return new FooterNavigation(driver, footerPageSectionElement);
    }

}
