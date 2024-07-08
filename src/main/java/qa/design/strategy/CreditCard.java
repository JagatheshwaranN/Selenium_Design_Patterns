package qa.design.strategy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class CreditCard implements PaymentMode {

    @FindBy(id = "cc")
    private WebElement cardNumber;

    @FindBy(id = "year")
    private WebElement cardYear;

    @FindBy(id = "cvv")
    private WebElement cardPin;

    @Override
    public void enterPaymentDetail(Map<String, String> paymentDetail) {
        this.cardNumber.sendKeys(paymentDetail.get("cardNumber"));
        this.cardYear.sendKeys(paymentDetail.get("cardYear"));
        this.cardPin.sendKeys(paymentDetail.get("cardPin"));
    }

}
