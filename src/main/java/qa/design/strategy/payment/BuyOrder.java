package qa.design.strategy.payment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyOrder {

    @FindBy(id = "buy")
    private WebElement buyNow;

    @FindBy(id = "ordernumber")
    private WebElement orderNumber;

    public BuyOrder(final WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public String purchaseOrder(){
        this.buyNow.click();
        return this.orderNumber.getText();
    }

}
