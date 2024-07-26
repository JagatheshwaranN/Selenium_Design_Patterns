package qa.design.srp.travel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Component {

    WebElement pageSectionElement;

    public Component(WebDriver driver, By locator){
        this.pageSectionElement = driver.findElement(locator);
    }

    public WebElement findElement(By locatorFindElement){
        return this.pageSectionElement.findElement(locatorFindElement);
    }

}
