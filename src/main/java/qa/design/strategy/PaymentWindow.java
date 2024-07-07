package qa.design.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PaymentWindow {

    protected final WebDriver driver;

    private final UserInformation userInformation;

    private final BuyOrder buyOrder;

    private PaymentMode paymentMode;

    public PaymentWindow(final WebDriver driver){
        this.driver = driver;
        this.userInformation = PageFactory.initElements(driver, UserInformation.class);
        this.buyOrder = PageFactory.initElements(driver, BuyOrder.class);
    }

    public void navigateTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/strategy.html");
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public BuyOrder getBuyOrder() {
        return buyOrder;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
        PageFactory.initElements(driver, this.paymentMode);
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

}
