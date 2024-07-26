package qa.design.srp.travel.abstractComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class Component {

    WebElement pageSectionElement;

    public Component(WebDriver driver, By locator){
        this.pageSectionElement = driver.findElement(locator);
    }

    public WebElement searchElement(By locatorFindElement){
        return this.pageSectionElement.findElement(locatorFindElement);
    }

    public List<WebElement> searchElements(By locatorFindElements){
        return this.pageSectionElement.findElements(locatorFindElements);
    }

}
