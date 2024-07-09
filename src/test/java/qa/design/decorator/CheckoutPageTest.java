package qa.design.decorator;

import com.google.common.util.concurrent.Uninterruptibles;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.design.test.BaseTest;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import static qa.design.decorator.CheckoutDecorator.*;

public class CheckoutPageTest extends BaseTest {

    protected CheckoutPage checkoutPage;

    @BeforeTest
    public void setCheckoutPage(){
        this.checkoutPage = new CheckoutPage(driver);
    }

    @Test(dataProvider = "fetchData")
    public void orderPurchaseTest(Consumer<CheckoutPage> checkoutPageConsumer){
        this.checkoutPage.navigateTo();
        checkoutPageConsumer.accept(this.checkoutPage);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    @DataProvider
    public Object[] fetchData(){
        return new Object[]{
                freeCoupon.andThen(buyOrder).andThen(successfulOrder),
                discountCoupon.andThen(creditCard).andThen(buyOrder).andThen(successfulOrder),
                creditCard.andThen(buyOrder).andThen(successfulOrder),
                invalidCreditCard.andThen(buyOrder).andThen(unSuccessfulOrder),
                invalidCreditCard.andThen(discountCoupon).andThen(buyOrder).andThen(unSuccessfulOrder),
                buyOrder.andThen(unSuccessfulOrder)
        };
    }

}
