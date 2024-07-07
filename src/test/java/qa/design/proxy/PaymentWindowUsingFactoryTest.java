package qa.design.proxy;

import com.google.common.util.concurrent.Uninterruptibles;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;
import qa.design.test.BaseTest;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PaymentWindowUsingFactoryTest extends BaseTest {

    private PaymentWindow paymentWindow;

    @BeforeTest
    public void setPaymentWindow() {
        System.setProperty("env", "PROD");
        this.paymentWindow = new PaymentWindow(driver);
    }

    @Test(dataProvider = "fetchData")
    public void paymentModeTest(String paymentMode, Map<String, String> paymentDetail) {
        this.paymentWindow.navigateTo();
        this.paymentWindow.getUserInformation().enterUserDetails("John", "Smith", "john.smith@gmail.com");
        this.paymentWindow.setPaymentMode(PaymentModeFactory.getInstance(paymentMode));
        this.paymentWindow.getPaymentMode().enterPaymentDetail(paymentDetail);
        String orderNumber = this.paymentWindow.getBuyOrder().placeOrder();
        System.out.println("Order Number : " + orderNumber);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    @DataProvider
    public Object[][] fetchData() {
        Map<String, String> creditCard = Maps.newHashMap();
        creditCard.put("cardNumber", "987634562312");
        creditCard.put("cardYear", "2024");
        creditCard.put("cardPin", "2325");

        Map<String, String> netBanking = Maps.newHashMap();
        netBanking.put("bank", "WELLS FARGO");
        netBanking.put("accountNumber", "987634562312");
        netBanking.put("accountPin", "2325");

        return new Object[][]{
                {"CC", creditCard},
                {"NB", netBanking}
        };
    }

}
