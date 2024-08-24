package qa.design.strategy.google;

import com.google.common.util.concurrent.Uninterruptibles;
import org.jboss.arquillian.graphene.Graphene;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qa.design.strategy.google.util.SpeakerUtil;

import java.time.Duration;

public class SpeechStrategyBackup implements SearchStrategy {

    protected  WebDriver driver;

    @FindBy(css = "div.XDyW0e")
    private WebElement microphone;

    @FindBy(name= "q")
    private WebElement searchBox;

    @FindBy(xpath = "//div[@class='lJ9FBc']//input[@name='btnK']")
    private WebElement searchButton;

    @FindBy(name="btnG")
    private WebElement searchButton1;

    @Override
    public void setDriver(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void search(String searchKeyword) {
        searchBox.clear();
        SpeakerUtil.allocate();
        startListen();
        SpeakerUtil.speak(searchKeyword);
        stopListen();
        System.out.println(getVoiceSearchText());
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        int length = searchKeyword.length();
        searchBox.sendKeys(searchKeyword.substring(0, length-1));
        Graphene.guardAjax(searchBox).sendKeys(searchKeyword.substring(length-1));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(searchButton));
        Graphene.guardAjax(searchButton).click();
    }

    private void startListen() {
        Graphene.waitGui()
                .until()
                .element(this.microphone)
                .is()
                .present();
        microphone.click();
        Graphene.waitGui()
                .until()
                .element(By.id("spchb"))
                .is()
                .present();
    }

    private void stopListen() {
        Graphene.waitGui()
                .until()
                .element(By.id("spchb"))
                .is()
                .not()
                .visible();
    }

    public String getVoiceSearchText() {
        Graphene.waitGui()
                .until()
                .element(this.searchBox)
                .is()
                .visible();
        return this.searchBox.getAttribute("value");
    }

}
