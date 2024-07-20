package qa.design.strategy.payment;

import java.util.Map;

public interface PaymentMode {

    void enterPaymentDetail(Map<String, String> paymentDetail);

}
