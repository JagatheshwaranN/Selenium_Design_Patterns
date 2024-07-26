package qa.design.srp.travel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterNavigation extends Component {

    WebDriver driver;

    By flights = By.cssSelector("[title='flights']");

    public FooterNavigation(WebDriver driver, By pageSectionElement){
        super(driver, pageSectionElement);
    }

}
