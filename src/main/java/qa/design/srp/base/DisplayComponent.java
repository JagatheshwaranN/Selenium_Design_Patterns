package qa.design.srp.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class DisplayComponent {

    protected WebDriverWait wdWait;

    public DisplayComponent(final WebDriver driver){
        this.wdWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public abstract boolean isDisplayed();
}
