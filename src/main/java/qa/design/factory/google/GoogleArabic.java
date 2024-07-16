package qa.design.factory.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

class GoogleArabic extends GoogleEnglish {

    @FindBy(css = "div#gws-output-pages-elements-homepage_additional_languages__als a")
    private List<WebElement> languageSelection;

    @FindBy(css = "span.ly0Ckb")
    private WebElement keyboardButton;

    @FindBy(id="kbd")
    private WebElement keyboard;

    public GoogleArabic(final WebDriver driver){
        super(driver);
    }

    @Override
    public void launch() {
        this.driver.get("https://www.google.com.sa/");
        this.languageSelection.stream()
                .filter(ele -> ele.isDisplayed() && ele.isEnabled())
                .findFirst()
                .ifPresent(WebElement::click);
    }

    @Override
    public void search(String keyword){
//        this.wait.until(driver -> this.keyboardButton.isDisplayed());
//        this.keyboardButton.click();
//        this.wait.until(driver -> this.keyboard.isDisplayed());
        super.search(keyword);
    }

}
