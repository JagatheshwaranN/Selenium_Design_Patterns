package qa.design.factory.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

class GoogleFrench extends GoogleEnglish {

    @FindBy(css = "div#gws-output-pages-elements-homepage_additional_languages__als a")
    private List<WebElement> languageSelection;

    public GoogleFrench(final WebDriver driver){
        super(driver);
    }

    @Override
    public void launch() {
        this.driver.get("https://www.google.fr/");
        this.languageSelection.stream()
                .filter(ele -> ele.isDisplayed() && ele.isEnabled())
                .findFirst()
                .ifPresent(WebElement::click);
    }

}
