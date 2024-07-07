package qa.design.command;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import qa.design.test.BaseTest;

public class AdminProHomePageTest extends BaseTest {

    private AdminProHomePage adminProHomePage;

    @BeforeTest
    public void setAdminProHomePage(){
        this.adminProHomePage = new AdminProHomePage(driver);
    }

    @Test
    public void adminProHomePageTest() {
        this.adminProHomePage.navigateTo();
        this.adminProHomePage.getObjectValidator()
                .stream()
                .map(ObjectValidator::validate)
                .forEach(Assert::assertTrue);
    }
}
