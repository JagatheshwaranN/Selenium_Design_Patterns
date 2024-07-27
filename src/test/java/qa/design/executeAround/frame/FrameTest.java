package qa.design.executeAround.frame;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import qa.design.test.BaseTest;

public class FrameTest extends BaseTest {

    protected MainPage mainPage;

    @BeforeTest
    public void setMainPage(){
        this.mainPage = new MainPage(driver);
    }

    @Test
    public void frameTest() {
        this.mainPage.navigateTo();
        this.mainPage.onFirstFrame(firstFrame -> {
            firstFrame.setFirstName("John");
            firstFrame.setLastName("Smith");
            firstFrame.setAddress("Texas");
            firstFrame.setMessage("Hello!");
        });
        this.mainPage.onSecondFrame(secondFrame -> {
            secondFrame.setFirstName("Alex");
            secondFrame.setLastName("Peterson");
            secondFrame.setAddress("Dallas");
            secondFrame.setMessage("Hai!");
        });
        this.mainPage.onThirdFrame(thirdFrame -> {
            thirdFrame.setFirstName("Erica");
            thirdFrame.setLastName("Simon");
            thirdFrame.setAddress("New York");
            thirdFrame.setMessage("Hello!");
        });
    }

}
