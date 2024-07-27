package qa.design.executeAround.travel.abstractComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class Component {

    WebDriver driver;

    WebElement pageSectionElement;

    public Component(WebDriver driver, By locator){
        this.driver = driver;
        this.pageSectionElement = driver.findElement(locator);
    }

    public WebElement searchElement(By locatorFindElement){
        return this.pageSectionElement.findElement(locatorFindElement);
    }

    public List<WebElement> searchElements(By locatorFindElements){
        return this.pageSectionElement.findElements(locatorFindElements);
    }

    public void waitForElementToDisappear(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

}
