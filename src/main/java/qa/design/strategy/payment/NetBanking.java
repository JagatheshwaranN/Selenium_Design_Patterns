package qa.design.strategy.payment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class NetBanking implements PaymentMode {

    @FindBy(id = "bank")
    private WebElement bank;

    @FindBy(id = "acc_number")
    private WebElement accountNumber;

    @FindBy(id = "pin")
    private WebElement accountPin;

    @Override
    public void enterPaymentDetail(Map<String, String> paymentDetail) {
        Select bankDropdown = new Select(bank);
        bankDropdown.selectByVisibleText(paymentDetail.get("bank"));
        this.accountNumber.sendKeys(paymentDetail.get("accountNumber"));
        this.accountPin.sendKeys(paymentDetail.get("accountPin"));
    }
    
}
