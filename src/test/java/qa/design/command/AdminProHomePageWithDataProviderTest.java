package qa.design.command;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.design.test.BaseTest;

public class AdminProHomePageWithDataProviderTest extends BaseTest {

    private AdminProHomePage adminProHomePage;

    @BeforeTest
    public void setAdminProHomePage() {
        this.adminProHomePage = new AdminProHomePage(driver);
    }

    @Test
    public void navigate() {
        this.adminProHomePage.navigateTo();
    }

    @Test(dataProvider = "fetchData", dependsOnMethods = "navigate")
    public void adminProHomePageTest(ObjectValidator objectValidator) {
        Assert.assertTrue(objectValidator.validate());
    }

    @DataProvider
    public Object[] fetchData() {
        return this.adminProHomePage.getObjectValidator().toArray();
    }

}
