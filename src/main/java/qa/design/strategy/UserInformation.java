package qa.design.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserInformation {

    @FindBy(id="fn")
    private WebElement firstName;

    @FindBy(id="ln")
    private WebElement lastName;

    @FindBy(id="email")
    private WebElement emailId;

    public UserInformation(final WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void enterUserDetails(String fName, String lName, String email){
        this.firstName.sendKeys(fName);
        this.lastName.sendKeys(lName);
        this.emailId.sendKeys(email);
    }

}
