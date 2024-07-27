package qa.design.srp.travel.pageComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import qa.design.srp.travel.abstractComponent.Component;

public class FooterNavigation extends Component {

    WebDriver driver;

    private static final By flights = By.cssSelector("[title='Flights']");

    private static final By links = By.cssSelector("a");


    public FooterNavigation(WebDriver driver, By pageSectionElement) {
        super(driver, pageSectionElement);
        this.driver = driver;
    }

    public void searchFlight() {
        System.out.println(searchElement(flights).getAttribute("class"));
        //findElement(flights).click();
    }

    public void getLinksCount() {
        System.out.println(searchElements(links).size());
    }

}
