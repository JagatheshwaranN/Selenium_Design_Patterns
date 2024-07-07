package qa.design.command;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class AdminProHomePage {

    private final WebDriver driver;

    // Buttons
    @FindBy(css = ".button-box .btn-info")
    private WebElement infoButton;

    @FindBy(css = ".button-box .btn-warning")
    private WebElement warnButton;

    @FindBy(css = ".button-box .btn-success")
    private WebElement successButton;

    @FindBy(css = ".button-box .btn-danger")
    private WebElement dangerButton;

    // Notifications
    @FindBy(css = ".jq-icon-info")
    private WebElement infoNotification;

    @FindBy(css = ".jq-icon-warning")
    private WebElement warnNotification;

    @FindBy(css = ".jq-icon-success")
    private WebElement successNotification;

    @FindBy(css = ".jq-icon-error")
    private WebElement dangerNotification;

    // Alert
    @FindBy(xpath = "//h4[text()='Dissmissal Alert']//following-sibling::div[contains(@class,'alert-success')]")
    private WebElement successAlert;

    @FindBy(xpath = "//h4[text()='Dissmissal Alert']//following-sibling::div[contains(@class,'alert-danger')]")
    private WebElement dangerAlert;

    @FindBy(xpath = "//h4[text()='Dissmissal Alert']//following-sibling::div[contains(@class,'alert-warning')]")
    private WebElement warnAlert;

    @FindBy(xpath = "//h4[text()='Dissmissal Alert']//following-sibling::div[contains(@class,'alert-info')]")
    private WebElement infoAlert;


    public AdminProHomePage(final WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/admin-template/admin-template.html");
    }

    public List<ObjectValidator> getObjectValidator() {
        return Arrays.asList(
                new NotificationValidator(infoButton, infoNotification),
                new NotificationValidator(warnButton, warnNotification),
                new NotificationValidator(successButton, successNotification),
                new NotificationValidator(dangerButton, dangerNotification),

                new AlertValidator(successAlert),
                new AlertValidator(dangerAlert),
                new AlertValidator(warnAlert),
                new AlertValidator(infoAlert)
        );
    }

}
