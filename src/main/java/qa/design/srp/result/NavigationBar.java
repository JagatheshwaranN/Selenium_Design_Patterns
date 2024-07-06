package qa.design.srp.result;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.design.srp.base.DisplayComponent;

public class NavigationBar extends DisplayComponent {

    @FindBy(id="hdtb")
    private WebElement navBar;

    @FindBy(linkText = "Videos")
    private WebElement videos;

    @FindBy(linkText = "News")
    private WebElement news;

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public void navigateToVideos() {
        this.videos.click();
    }

    public void navigateToNews() {
        this.news.click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wdWait.until(driver -> this.navBar.isDisplayed());
    }

}
