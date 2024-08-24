package qa.design.strategy.google;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qa.design.strategy.google.util.SpeakerUtil;

import java.time.Duration;

public class SpeechStrategy implements SearchStrategy {

    protected  WebDriver driver;

    @FindBy(css = "div.XDyW0e")
    private WebElement microphone;

    @FindBy(id = "spchb")
    private WebElement microphoneUI;

    @FindBy(name= "q")
    private WebElement searchBox;

    @FindBy(xpath = "//div[@class='lJ9FBc']//input[@name='btnK']")
    private WebElement searchButton;

    @Override
    public void setDriver(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void search(String searchKeyword) {
        searchBox.clear();
        SpeakerUtil.allocate();
        handleMicrophone();
        SpeakerUtil.deallocate();
        SpeakerUtil.speak(searchKeyword);
        System.out.println(getSearchText());
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
    }

    private void handleMicrophone() {
        this.microphone.click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(microphoneUI));
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
    }

    private String getSearchText() {
        return this.searchBox.getAttribute("value");
    }

}
