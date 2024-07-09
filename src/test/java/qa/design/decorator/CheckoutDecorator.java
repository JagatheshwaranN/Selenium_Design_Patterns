package qa.design.decorator;

import org.testng.Assert;

import java.util.function.Consumer;

public class CheckoutDecorator {

    public static final Consumer<CheckoutPage> freeCoupon = checkoutPage -> checkoutPage.payByPromoCode("FREEUDEMY");
    public static final Consumer<CheckoutPage> discountCoupon = checkoutPage -> checkoutPage.payByPromoCode("PARTIALUDEMY");
    public static final Consumer<CheckoutPage> creditCard = checkoutPage -> checkoutPage.payByCard("4111111111111111", "2024", "123");
    public static final Consumer<CheckoutPage> invalidCreditCard = checkoutPage -> checkoutPage.payByCard("4111111111111111", "2021", "123");
    public static final Consumer<CheckoutPage> buyOrder = CheckoutPage::buyProduct;

    public static final Consumer<CheckoutPage> successfulOrder = checkoutPage -> Assert.assertEquals(checkoutPage.getOrderStatus(), "PASS");
    public static final Consumer<CheckoutPage> unSuccessfulOrder = checkoutPage -> Assert.assertEquals(checkoutPage.getOrderStatus(), "FAIL");

}
