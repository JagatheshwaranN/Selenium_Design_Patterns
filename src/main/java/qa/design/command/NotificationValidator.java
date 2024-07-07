package qa.design.command;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class NotificationValidator extends ObjectValidator {

    private final WebElement button;

    private final WebElement notification;

    public NotificationValidator(final WebElement button,  final WebElement notification){
        this.button = button;
        this.notification = notification;
    }

    @Override
    public boolean validate() {
        this.button.click();
        boolean visibleState = this.notification.isDisplayed();
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
        boolean hiddenState = this.notification.isDisplayed();
        return visibleState && (!hiddenState);
    }

}
