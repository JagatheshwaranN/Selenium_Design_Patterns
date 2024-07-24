package qa.fp.stream;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.fp.payment.PaymentPage;
import qa.fp.supplier.DriverFactory;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class PaymentTest {

    static class PaymentScreenAction {

        public static final Consumer<PaymentPage> freeCoupon = (p) -> p.payByPromoCode("FREEUDEMY");
        public static final Consumer<PaymentPage> partialCoupon = (p) -> p.payByPromoCode("PARTIALUDEMY");
        public static final Consumer<PaymentPage> validCreditCard = (p) -> p.payByCard("4111111111111111", "2024", "123");
        public static final Consumer<PaymentPage> invalidCreditCard = (p) -> p.payByCard("4111111111111112", "2024", "123");
        public static final Consumer<PaymentPage> buy = PaymentPage::buyProduct;

        public static final Consumer<PaymentPage> successfulPurchase = (p) -> Assert.assertEquals(p.getOrderStatus(), "PASS");
        public static final Consumer<PaymentPage> failedPurchase = (p) -> Assert.assertEquals(p.getOrderStatus(), "FAIL");
    }

    private WebDriver driver;
    private PaymentPage paymentPage;


    @BeforeTest
    public void setUp() {
        if (this.driver == null)
            this.driver = DriverFactory.getDriver("Chrome");
        this.driver.manage().window().maximize();
        this.paymentPage = new PaymentPage(driver);
    }

    @AfterTest
    public void tearDown() {
        if (this.driver != null)
            this.driver.quit();
    }

    @Test(dataProvider = "getTestData")
    public void paymentTest(Consumer<PaymentPage> paymentPageConsumer) {
        paymentPage.navigateTo();
        paymentPageConsumer.accept(paymentPage);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    @DataProvider
    public Object[] getTestData() {
        return new Object[]{
                PaymentScreenAction.freeCoupon.andThen(PaymentScreenAction.buy).andThen(PaymentScreenAction.successfulPurchase),
                PaymentScreenAction.partialCoupon.andThen(PaymentScreenAction.validCreditCard).andThen(PaymentScreenAction.buy).andThen(PaymentScreenAction.successfulPurchase),
                PaymentScreenAction.validCreditCard.andThen(PaymentScreenAction.buy).andThen(PaymentScreenAction.successfulPurchase),
                PaymentScreenAction.invalidCreditCard.andThen(PaymentScreenAction.buy).andThen(PaymentScreenAction.failedPurchase),
                PaymentScreenAction.invalidCreditCard.andThen(PaymentScreenAction.partialCoupon).andThen(PaymentScreenAction.buy).andThen(PaymentScreenAction.failedPurchase),
                PaymentScreenAction.buy.andThen(PaymentScreenAction.failedPurchase)
        };
    }

}
