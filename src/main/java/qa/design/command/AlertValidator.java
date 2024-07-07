package qa.design.command;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AlertValidator extends ObjectValidator {

    private final WebElement alert;

    public AlertValidator(final WebElement alert) {
        this.alert = alert;
    }

    @Override
    public boolean validate() {
        boolean visibleState = this.alert.isDisplayed();
        this.alert.findElement(By.xpath("//button[@class='close']")).click();
        boolean hiddenState = false;
        try{
            hiddenState = this.alert.isDisplayed();
        }catch (Exception ignored){
        }
        return visibleState && (!hiddenState);
    }

}
