package qa.design.decorator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DashboardPage {

    private final WebDriver driver;

    @FindBy(id="role")
    private WebElement userRole;

    @FindBy(css = "div.guest")
    private List<WebElement> guestItems;

    @FindBy(css = "div.superuser")
    private List<WebElement> superUserItems;

    @FindBy(css = "div.admin")
    private List<WebElement> adminItems;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/decorator.html");
    }

    public void selectUserRole(String userRole){
        Select userRoleDropdown = new Select(this.userRole);
        userRoleDropdown.selectByValue(userRole);
    }

    public List<WebElement> getGuestItems() {
        return guestItems;
    }

    public List<WebElement> getSuperUserItems() {
        return superUserItems;
    }

    public List<WebElement> getAdminItems() {
        return adminItems;
    }

}

