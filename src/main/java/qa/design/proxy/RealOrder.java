package qa.design.proxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RealOrder implements OrderComponent {

    @FindBy(id = "buy")
    private WebElement buyNow;

    @FindBy(id = "ordernumber")
    private WebElement orderNumber;

    public RealOrder(final WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @Override
    public String placeOrder() {
        this.buyNow.click();
        return this.orderNumber.getText();
    }

}
