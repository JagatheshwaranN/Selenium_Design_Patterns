package qa.design.decorator;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.function.Consumer;

public class Decorators {

    private static void verifyDisplay(List<WebElement> elementList){
        elementList.forEach(element -> Assert.assertTrue(element.isDisplayed()));
    }

    private static void verifyNotDisplay(List<WebElement> elementList){
        elementList.forEach(element -> Assert.assertFalse(element.isDisplayed()));
    }

    private static final Consumer<DashboardPage> guestItemsPresence = dashboard -> verifyDisplay(dashboard.getGuestItems());
    private static final Consumer<DashboardPage> superUserItemsPresence = dashboard -> verifyDisplay(dashboard.getSuperUserItems());
    private static final Consumer<DashboardPage> adminItemsPresence = dashboard -> verifyDisplay(dashboard.getAdminItems());

    private static final Consumer<DashboardPage> guestItemsNotPresence = dashboard -> verifyNotDisplay(dashboard.getGuestItems());
    private static final Consumer<DashboardPage> superUserItemsNotPresence = dashboard -> verifyNotDisplay(dashboard.getSuperUserItems());
    private static final Consumer<DashboardPage> adminItemsNotPresence = dashboard -> verifyNotDisplay(dashboard.getAdminItems());

    private static final Consumer<DashboardPage> guestSelection = dashboard -> dashboard.selectUserRole("guest");
    private static final Consumer<DashboardPage> superUserSelection = dashboard -> dashboard.selectUserRole("superuser");
    private static final Consumer<DashboardPage> adminSelection = dashboard -> dashboard.selectUserRole("admin");

    public static final Consumer<DashboardPage> guestPageBeforeSelection = guestItemsNotPresence;
    public static final Consumer<DashboardPage> guestPage = guestSelection.andThen(guestItemsPresence)
            .andThen(superUserItemsNotPresence).andThen(adminItemsNotPresence);
    public static final Consumer<DashboardPage> superUserPage = superUserSelection.andThen(superUserItemsPresence)
            .andThen(guestItemsPresence).andThen(adminItemsNotPresence);
    public static final Consumer<DashboardPage> adminPage = adminSelection.andThen(adminItemsPresence)
            .andThen(superUserItemsPresence).andThen(guestItemsPresence);

}
