package qa.design.decorator;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.design.test.BaseTest;

import java.util.function.Consumer;

public class DashboardPageTest extends BaseTest {

    protected DashboardPage dashboardPage;

    @BeforeTest
    public void setDashboardPage(){
        this.dashboardPage = new DashboardPage(driver);
    }

    @Test(dataProvider = "fetchData")
    public void userRoleTest(Consumer<DashboardPage> dashboardPageConsumer){
        this.dashboardPage.navigateTo();
        dashboardPageConsumer.accept(this.dashboardPage);
    }

    @DataProvider
    public Object[] fetchData() {
        return new Object[]{
                Decorators.guestPageBeforeSelection,
                Decorators.guestPage,
                Decorators.superUserPage,
                Decorators.adminPage
        };
    }

}
