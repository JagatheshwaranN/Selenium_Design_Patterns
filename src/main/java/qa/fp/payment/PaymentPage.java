package qa.fp.payment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    private final WebDriver driver;

    @FindBy(id = "coupon")
    private WebElement couponCode;

    @FindBy(id="couponbtn")
    private WebElement couponApplyButton;

    @FindBy(id = "cc")
    private WebElement creditCardNumber;

    @FindBy(id = "year")
    private WebElement creditCardYear;

    @FindBy(id = "cvv")
    private WebElement creditCardPin;

    @FindBy(id = "buy")
    private WebElement buyNowNButton;

    @FindBy(id = "status")
    private WebElement orderStatus;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-payment-screen.html");
    }

    public void payByPromoCode(String couponCode){
        this.couponCode.sendKeys(couponCode);
        this.couponApplyButton.click();
    }

    public void payByCard(String creditCardNumber, String creditCardYear, String creditCardPin) {
        this.creditCardNumber.sendKeys(creditCardNumber);
        this.creditCardYear.sendKeys(creditCardYear);
        this.creditCardPin.sendKeys(creditCardPin);
    }

    public void buyProduct(){
        this.buyNowNButton.click();
    }

    public String getOrderStatus(){
        return this.orderStatus.getText().trim();
    }

}
