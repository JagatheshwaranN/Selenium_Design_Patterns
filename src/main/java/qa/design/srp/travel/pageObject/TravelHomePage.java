package qa.design.srp.travel.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import qa.design.srp.travel.pageComponents.FooterNavigation;
import qa.design.srp.travel.pageComponents.TopNavigation;

public class TravelHomePage {

    WebDriver driver;

    By topPageSectionElement = By.id("buttons");

    By footerPageSectionElement = By.id("traveller-home");

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
