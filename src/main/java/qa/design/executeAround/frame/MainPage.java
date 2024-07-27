package qa.design.executeAround.frame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.function.Consumer;

public class MainPage {

    private final WebDriver driver;

    @FindBy(id = "a")
    private WebElement firstFrame;

    @FindBy(id = "b")
    private WebElement secondFrame;

    @FindBy(id = "c")
    private WebElement thirdFrame;

    protected FirstFrame firstFrameRef;

    protected SecondFrame secondFrameRef;

    protected ThirdFrame thirdFrameRef;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        firstFrameRef = PageFactory.initElements(driver, FirstFrame.class);
        secondFrameRef = PageFactory.initElements(driver, SecondFrame.class);
        thirdFrameRef = PageFactory.initElements(driver, ThirdFrame.class);
    }

    public void navigateTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/main.html");
    }

    public void onFirstFrame(Consumer<FirstFrame> firstFrameConsumer){
        this.driver.switchTo().frame(firstFrame);
        firstFrameConsumer.accept(this.firstFrameRef);
        this.driver.switchTo().defaultContent();
    }

    public void onSecondFrame(Consumer<SecondFrame> secondFrameConsumer){
        this.driver.switchTo().frame(secondFrame);
        secondFrameConsumer.accept(this.secondFrameRef);
        this.driver.switchTo().defaultContent();
    }

    public void onThirdFrame(Consumer<ThirdFrame> thirdFrameConsumer){
        this.driver.switchTo().frame(thirdFrame);
        thirdFrameConsumer.accept(this.thirdFrameRef);
        this.driver.switchTo().defaultContent();
    }

}
